package com.example.apiexception.api.response;

import java.io.Serializable;

/**
 * @author wanggl
 */
public class BaseStatusSupportResponse<T> extends StatusSupportResponse implements Serializable {
    private static final long serialVersionUID = 2611556444074013268L;
    protected T data;

    public BaseStatusSupportResponse() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
