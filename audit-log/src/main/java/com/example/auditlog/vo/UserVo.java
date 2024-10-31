package com.example.auditlog.vo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2024/10/28 15:50
 */
@Data
public class UserVo {

    private String name;
    private Integer age;
    private MultipartFile file;
}
