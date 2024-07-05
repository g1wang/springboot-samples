package com.example.springbooti18n.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class UserDto {
    @NotNull(message = "请输入name")
    @Length(message = "名称不能超过个 {max} 字符", max = 10)
    private String username;
    @NotBlank(message = "请输入邮箱")
    private String email;
    @NotEmpty(message = "请输入地址")
    @Size(message = "地址最多为{max}个", max = 2)
    private List<String> addressList;
    @NotNull(message = "user.age")
    @Range(message = "年龄范围为 {min} 到 {max} 之间", min = 1, max = 100)
    private Integer age;
}
