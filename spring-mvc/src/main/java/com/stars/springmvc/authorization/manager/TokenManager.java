package com.stars.springmvc.authorization.manager;

import com.stars.springmvc.authorization.model.TokenModel;

/**
 * @Author laboratory
 * @Description 对Token进行操作的接口
 * @Date 2023/1/9
 * @Param
 * @return
 **/
public interface TokenManager {

    /**
     * 创建一个token关联上指定用户
     *
     * @param userId 指定用户的id
     * @return 生成的token
     */
    TokenModel createToken(long userId);

    /**
     * 检查token是否有效
     *
     * @param model token
     * @return 是否有效
     */
    boolean checkToken(TokenModel model);

    /**
     * 从字符串中解析token
     *
     * @param authentication 加密后的字符串
     * @return
     */
    TokenModel getToken(String authentication);

    /**
     * 清除token
     *
     * @param userId 登录用户的id
     */
    void deleteToken(long userId);

}
