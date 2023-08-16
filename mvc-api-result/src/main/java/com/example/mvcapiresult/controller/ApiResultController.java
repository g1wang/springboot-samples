package com.example.mvcapiresult.controller;

import com.example.mvcapiresult.annotation.ResultHandler;
import com.example.mvcapiresult.api.response.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanggl
 */
@RestController
@RequestMapping("/apiResult")
public class ApiResultController {

    @GetMapping("nothing")
    public R<?> getNothing() {
        return R.success();
    }

    @GetMapping("something")
    public R<?> getSomething() {
        return R.success("something");
    }

    @GetMapping("businessError")
    public R<?> getbusinessError()  {
        return R.error("E0003","查无用户");
    }

    @GetMapping("sysError")
    public R<?> getsysError() throws Exception {
        throw  new Exception("无知的人类");
    }

    @ResultHandler
    @GetMapping("resultException")
    public R<?> getResultException() throws Exception {
        //System.out.printf(String.valueOf(1/0));
        throw  new Exception("no no no");
    }
}
