package com.f1soft.learning.studentmanagement.config;

import com.f1soft.learning.studentmanagement.platform.filter.StudentApiFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<StudentApiFilter> loggingFilter() {
        FilterRegistrationBean<StudentApiFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new StudentApiFilter());
        registrationBean.addUrlPatterns("/api/v1/*");
        return registrationBean;
    }
}