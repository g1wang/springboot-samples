package com.example.auditlog.web;

import com.example.auditlog.aspect.AuditLog;
import com.example.auditlog.vo.UserVo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description:
 * @Author wanggl
 * @Date 2024/10/23 9:54
 */
@RestController
@RequestMapping("user")
public class UserController {
    @GetMapping
    @AuditLog(operation = "getuser",operationType = "get",logType = "log",appType = "web")
    public String getUser(String name) {
        return "u" + name;
    }

    @PostMapping
    @AuditLog(operation = "postuser",operationType = "新增",logType = "log",appType = "web")
    public UserVo postUser(@RequestBody UserVo userVo) {
        userVo.setAge(11);
        return userVo;
    }
}
