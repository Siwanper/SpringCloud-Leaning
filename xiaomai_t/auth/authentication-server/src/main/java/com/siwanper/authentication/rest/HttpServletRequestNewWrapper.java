package com.siwanper.authentication.rest;

import lombok.Data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2020-04-28 4:31 PM
 */
public class HttpServletRequestNewWrapper extends HttpServletRequestWrapper {

    private String url;
    private String method;

    public HttpServletRequestNewWrapper(HttpServletRequest request, String url, String method) {
        super(request);
        this.url = url;
        this.method = method;
    }

    @Override
    public String getMethod() {
        return this.method;
    }

    @Override
    public String getServletPath() {
        return this.url;
    }
}
