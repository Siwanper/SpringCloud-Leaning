package com.siwanper.core.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 名称：LoginInterceptor
 * 描述：TODO
 *
 * @author chenjie
 * @date 2020/11/20  4:56 下午
 */

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String uri = request.getRequestURI();
//        String contextPath = request.getContextPath();
//
//        HttpSession session = request.getSession();
//
//        System.out.println("uri == " + uri);
//        System.out.println("contextPath == " + contextPath);
//
//        Object user = session.getAttribute("user");
//        if (null == user) {
//            response.sendRedirect(contextPath+"/home/");
//            return false;
//        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
