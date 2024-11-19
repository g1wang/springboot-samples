package com.example.auditlog.web;

import com.example.auditlog.aspect.AuditLog;
import com.example.auditlog.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author wanggl
 * @Date 2024/10/23 9:54
 */
@RestController
@RequestMapping("user")
public class UserController {
    @GetMapping
    @AuditLog(operation = "getuser", operationType = "get", logType = "log", appType = "web")
    public Object getUser(String name) {
        return "U" + name;
    }

    @PostMapping
    @AuditLog(operation = "postuser", operationType = "新增", logType = "log", appType = "web")
    public UserVo postUser(@RequestBody UserVo userVo) {
        userVo.setAge(11);
        return userVo;
    }

    @GetMapping("exce")
    public Object getEx() throws Exception {
        throw new Exception("wocuola");
    }


}
