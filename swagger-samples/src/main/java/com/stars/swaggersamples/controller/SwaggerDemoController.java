package com.stars.swaggersamples.controller;

import com.stars.swaggersamples.model.User;
import com.stars.swaggersamples.model.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * 用户接口类
 *
 * @author admin
 */
@Tag(name = "用户管理")
@RequestMapping("/user")
@RestController
public class SwaggerDemoController {

    /**
     * get params in path
     *
     * @param userId
     * @return
     */
    @Operation(tags = "用户管理", summary = "获取用户信息1", description = "获取指定用户的用户信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "成功", content = {
                    @Content(mediaType = "application/json")
            }),
            @ApiResponse(responseCode = "400", description = "失败", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
            }),
    })
    @GetMapping(value = "/{userId}")
    public UserResponse getUserInfo(
            @Parameter(name = "userId", description = "用户ID") @PathVariable(name = "userId") String userId) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId("123");
        userResponse.setName("qwerasdf");
        return userResponse;
    }

    /**
     * get  params in query
     *
     * @param name
     * @return
     */
    @Operation(tags = "用户管理", summary = "获取用户信息2", description = "获取指定用户的用户信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "成功", content = {
                    @Content(mediaType = "application/json")
            }),
            @ApiResponse(responseCode = "400", description = "失败", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
            }),
    })
    @GetMapping
    public UserResponse getUserInfoByName(
            @Parameter(name = "name", required = true, description = "用户名") String name) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId("123");
        userResponse.setName(name);
        return userResponse;
    }

    /**
     * get  params in header
     *
     * @param token
     * @return
     */
    @Operation(tags = "用户管理", summary = "用户登出", description = "用户登出")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "成功", content = {
                    @Content(mediaType = "application/json")
            }),
            @ApiResponse(responseCode = "400", description = "失败", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
            }),
    })
    @GetMapping("logout")
    public UserResponse getUserInfoByHeader(
            @Parameter(name = "token", required = true, description = "用户token") @RequestHeader(name = "token") String token) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId("123");
        userResponse.setName(token);
        return userResponse;
    }


    @Operation(tags = "用户管理", summary = "保存用户信息", description = "保存用户信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "成功", content = {
                    @Content(mediaType = "application/json")
            }),
            @ApiResponse(responseCode = "400", description = "失败", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
            }),
    })
    @PostMapping
    public UserResponse saveUserInfo(@RequestBody User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setName(user.getName());
        return userResponse;
    }
}
