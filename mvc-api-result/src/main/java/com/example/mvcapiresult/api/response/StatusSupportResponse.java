package com.example.mvcapiresult.api.response;

/**
 * @author wanggl
 */
public abstract class StatusSupportResponse implements Response{
    private static final long serialVersionUID = 8320260977262232283L;
    protected String errCode = "0";
    protected String errMsg;

    public StatusSupportResponse() {
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
}
