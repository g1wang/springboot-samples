package com.example.auditlog.web;

import com.example.auditlog.aspect.AuditLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String getUser(Integer id) {
        return "u" + id;
    }
}
