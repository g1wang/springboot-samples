package com.stars.springmvc.controller;

import com.stars.springmvc.authorization.annotation.Authorization;
import com.stars.springmvc.authorization.annotation.CurrentUser;
import com.stars.springmvc.authorization.manager.TokenManager;
import com.stars.springmvc.authorization.model.TokenModel;
import com.stars.springmvc.constant.ResultStatus;
import com.stars.springmvc.domain.User;
import com.stars.springmvc.model.ResultModel;
import com.stars.springmvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author laboratory
 * @Date 2022/12/21 13:50
 */

@RestController
@RequestMapping("/author")
public class AuthorizationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenManager tokenManager;


    @GetMapping
    @Authorization
    public ResponseEntity<ResultModel> hello(String name){
        String result = "hello world,"+name;
        return new ResponseEntity<>(ResultModel.ok(result), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ResultModel> login(@RequestParam String username, @RequestParam String password) {
        Assert.notNull(username, "username can not be empty");
        Assert.notNull(password, "password can not be empty");

        User user = userRepository.findByUsername(username);
        if (user == null ||  //未注册
                !user.getPassword().equals(password)) {  //密码错误
            //提示用户名或密码错误
            return new ResponseEntity<>(ResultModel.error(ResultStatus.USERNAME_OR_PASSWORD_ERROR), HttpStatus.NOT_FOUND);
        }
        //生成一个token，保存用户登录状态
        TokenModel model = tokenManager.createToken(user.getId());
        return new ResponseEntity<>(ResultModel.ok(model), HttpStatus.OK);
    }

    @DeleteMapping
    @Authorization
    public ResponseEntity<ResultModel> logout(@CurrentUser User user) {
        tokenManager.deleteToken(user.getId());
        return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK);
    }
}
