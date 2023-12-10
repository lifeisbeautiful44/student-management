package com.f1soft.learning.studentmanagement.platform.filter;

import com.f1soft.learning.studentmanagement.exception.StudentApiException;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentApiFilter implements Filter {

    private String key = "admin";
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String secret_key = request.getHeader("secret_key");

        if (request.getMethod().equals("POST")) {
            if (secret_key != null && secret_key.equals(key)) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                //sendErrorResponse(response, 404, "Unauthorized user");
                throw new StudentApiException(400, "Unauthorized user");
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    private void sendErrorResponse(HttpServletResponse response, int status, String message) throws IOException {
        response.setStatus(status);
        response.setContentType("application/json");
        response.getWriter().write("{\"error\": \"" + message + "\"}");
    }
}
