package com.siwanper.dao.model.login;

import java.io.Serializable;

/**
 * 名称：LoginModel
 * 描述：TODO
 *
 * @author chenjie
 * @date 2021/1/12  12:03 下午
 */
public class LoginModel implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 登录状态
     * 0:登录失败 1:登录成功
     */
    private int status;
    /**
     * 登录信息
     */
    private String msg;
    /**
     * 登录成功跳转链接
     */
    private String url;
    /**
     * 记住密码
     */
    private boolean remember;

    public LoginModel(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public LoginModel(int status, String msg, String url, boolean remember) {
        this.status = status;
        this.msg = msg;
        this.url = url;
        this.remember = remember;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isRemember() {
        return remember;
    }

    public void setRemember(boolean remember) {
        this.remember = remember;
    }
}
