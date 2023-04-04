package com.stars.swaggersamples.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "用户对象响应",description = "用户对象响应")
public class UserResponse {
    @Schema(name = "id",required = true,description = "用户ID")
    private String id;
    @Schema(name = "name",required = true,description = "用户名")
    private String name;
}
