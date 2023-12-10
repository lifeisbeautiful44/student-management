package com.f1soft.learning.studentmanagement.platform.interceptor;

import jakarta.annotation.Nullable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LogTimeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("pre handle ()  method");
        request.setAttribute("startTime",System.currentTimeMillis());
        return true;
    }


    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler,
              ModelAndView modelAndView) throws Exception {
          long time = (long) request.getAttribute("startTime");
          long timeTaken = System.currentTimeMillis() - time;
          System.out.println("The time taken for processing the request it " + timeTaken + " milliseconds.");
    }



}
