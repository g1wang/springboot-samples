package com.example.mybatisplussample.configuration;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2024/7/1 10:47
 */
@Component
public class MyMetaObjectHandler  implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);

        //设置版本号version的初始值为1
        //不加这个也可以，version的默认值为null，加了就是设置version的值从1开始
        this.setFieldValByName("version",1,metaObject);

        //添加deleted的初始值为0，也就是默认值
        this.setFieldValByName("deleted", 0, metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
