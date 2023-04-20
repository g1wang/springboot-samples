package com.stars.springbootadminserver.dingding;

import com.alibaba.fastjson2.JSONObject;
import de.codecentric.boot.admin.server.domain.entities.Instance;
import de.codecentric.boot.admin.server.domain.entities.InstanceRepository;
import de.codecentric.boot.admin.server.domain.events.InstanceEvent;
import de.codecentric.boot.admin.server.domain.events.InstanceStatusChangedEvent;
import de.codecentric.boot.admin.server.domain.values.InstanceId;
import de.codecentric.boot.admin.server.notify.AbstractStatusChangeNotifier;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Map;

/**
 * 正常情况下我们一般只会重写 doNotify(InstanceEvent event, Instance instance)这个方法，
 * 但实际上还要重写shouldNotify(InstanceEvent event, Instance instance)方法
 * 父类中不会对上线的状态进行推送
 */
@Slf4j
public class DingDingNotifier extends AbstractStatusChangeNotifier {
    public DingDingNotifier(InstanceRepository repository) {
        super(repository);
    }

    //默认情况下监控不到上线的状态
    //因为父类 AbstractStatusChangeNotifier 的属性 ignoreChanges 忽略了上线状态，不进行通知
    //故 重写 ignoreChanges 属性 和shouldNotify()方法（其实只修改了ignoreChanges 属性）
    //将 UNKNOWN:UP 改为 *:* 可以监控所有的状态变化
    private final String[] ignoreChanges = {"*:*"};

    /**
     * 消息模板
     */
    private static final String template = "<<<%s>>> \n 【服务名】: %s(%s) \n 【状态】: %s(%s) \n 【服务ip】: %s \n 【详情】: %s";

    private String titleAlarm = "服务警告";//这里必须要和配置的钉钉机器人中的关键字保持一致

    @Override
    protected boolean shouldNotify(InstanceEvent event, Instance instance) {
        if (event instanceof InstanceStatusChangedEvent) {
            InstanceStatusChangedEvent statusChange = (InstanceStatusChangedEvent) event;
            String from = this.getLastStatus(event.getInstance());
            String to = statusChange.getStatusInfo().getStatus();
            return Arrays.binarySearch(ignoreChanges, from + ":" + to) < 0
                    && Arrays.binarySearch(ignoreChanges, "*:" + to) < 0
                    && Arrays.binarySearch(ignoreChanges, from + ":*") < 0;
        }
        return false;
    }

    @Override
    protected Mono<Void> doNotify(InstanceEvent event, Instance instance) {
        String serverName = instance.getRegistration().getName();
        InstanceId instanceId = event.getInstance();
        String status = ((InstanceStatusChangedEvent) event).getStatusInfo().getStatus();
        String serviceUrl = instance.getRegistration().getServiceUrl();
        Map<String, Object> details = instance.getStatusInfo().getDetails();

        log.info("Instance {} ({}) is {}", serverName, instanceId, status);

        String serverStatus = null;
        switch (status) {
            case "DOWN": // 监控的健康信息中只要有一个down，都会提示服务down了
                serverStatus = "健康检查没通过";
                break;
            case "OFFLINE":
                serverStatus = "服务离线";
                break;
            case "UP":
                serverStatus = "服务上线";
                break;
            case "UNKNOWN":
                serverStatus = "服务未知异常";
                break;
            default:
                break;
        }
        String messageText = String.format(template, titleAlarm, serverName, instanceId, status, serverStatus, serviceUrl, JSONObject.toJSONString(details));
        return Mono.fromRunnable(() -> DingDingMessageUtil.sendTextMessage(messageText));
    }
}
