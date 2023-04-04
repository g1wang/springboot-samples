package com.stars.swaggersamples.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "用户对象",description = "用户对象")
public class User {
    @Schema(name = "id",required = true,description = "用户ID")
    private String id;
    @Schema(name = "name",required = true,description = "用户名")
    private String name;
    @Schema(name = "age",hidden = true,description = "年龄")
    private String age;
}
