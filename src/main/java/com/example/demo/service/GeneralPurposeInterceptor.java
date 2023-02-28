package com.example.demo.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;



public class GeneralPurposeInterceptor implements HandlerInterceptor {
    private final Logger LOG = LoggerFactory.getLogger(GeneralPurposeInterceptor.class);

    public boolean preHandler(HttpServletRequest request, HttpServletResponse response,Object handler)throws Exception{

        LOG.info("Pre Handle method");
        return true;
    }

    public boolean postHandler(HttpServletRequest request, HttpServletResponse response,Object handler)throws Exception{
        LOG.info("Post Handle method");
        return true;
    }

    public boolean afterCompletion(HttpServletRequest request, HttpServletResponse response,Object handler)throws Exception{
        LOG.info("after completion method");
        return true;
    }



}
