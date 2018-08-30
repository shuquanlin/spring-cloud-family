package com.spring.usercenter.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author sql
 * @Date 10:072018\7\10 0010
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        // 获取session
        HttpSession session = httpServletRequest.getSession(true);
        // 判断用户ID是否存在，不存在就跳转到登录界面
        if (session.getAttribute("userId") == null) {
            System.out.println(httpServletRequest.getContextPath());
            httpServletResponse.sendRedirect("/user/login");
            return false;
        }

        return true;


    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
