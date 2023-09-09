package com.qrm.system.config;


import com.qrm.system.filter.CrossFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Bean
    public FilterRegistrationBean<CrossFilter> crossFilter() {
        FilterRegistrationBean<CrossFilter> registrationBean
                = new FilterRegistrationBean<>(new CrossFilter());

        registrationBean.addUrlPatterns("/*");

        registrationBean.setOrder(-100);
        return registrationBean;
    }
}
