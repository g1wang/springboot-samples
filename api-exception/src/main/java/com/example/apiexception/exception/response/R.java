package com.example.apiexception.exception.response;

/**
 * @author wanggl
 */
public class R<T> extends StatusResponse<T> {
    private static final long serialVersionUID =2611556444074013269L;

    public R() {
    }
    public static R<?> success(){
        R<?> rsp = new R();
        return rsp;
    }

    public static R<?> error(String errCode,String errMsg){
        R<?> rsp = new R();
        rsp.errCode = errCode;
        rsp.errMsg = errMsg;
        return rsp;
    }

    public static R<?> error(String errMsg){
        R<?> rsp = new R();
        rsp.errCode = "E0000";
        rsp.errMsg = errMsg;
        return rsp;
    }

    public static <T> R<T> success(T data){
        R<T> rsp = new R();
        rsp.setData(data);
        return rsp;
    }
}
