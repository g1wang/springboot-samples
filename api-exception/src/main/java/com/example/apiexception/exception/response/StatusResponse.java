package com.example.apiexception.exception.response;

/**
 * @author wanggl
 */
public abstract class StatusResponse<T> implements Response{
    protected String errCode = "0";
    protected String errMsg;
    protected T data;

    public StatusResponse() {
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
