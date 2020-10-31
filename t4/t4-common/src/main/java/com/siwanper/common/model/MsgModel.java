package com.siwanper.common.model;

import java.io.Serializable;

/**
 * 封装返回前段数据模型
 */
public class MsgModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String status;

    private String message;

    private Object object;

    public MsgModel() {
    }

    public MsgModel(String message) {
        this.message = message;
    }

    public MsgModel(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public MsgModel(String status, String message, Object object) {
        this.status = status;
        this.message = message;
        this.object = object;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
