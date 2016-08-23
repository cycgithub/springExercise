package com.dataTrans;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by chenyuchao on 2016/8/19.
 */
public class AuthManager implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object){
        System.out.println("preHandle handle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView){

        System.out.println("postHandle handle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request,HttpServletResponse response,Object object,Exception ex){

        System.out.println("afterCompletion handle");
    }
}
