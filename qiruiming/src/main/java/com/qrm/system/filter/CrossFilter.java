package com.qrm.system.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class CrossFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("初始化跨域过滤器");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        // 允许所有的请求域名访问我们的跨域资源，可以固定单个或者多个内容
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");

        // 允许所有的请求域名访问我们的跨域资源，可以固定单个或者多个内容
        // httpResponse.setHeader("Access-Control-Allow-Origin", "http://localhost:9090");

        // 允许何种请求方法访问该跨域资源服务器
        httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        // 预检请求的有效期，单位为秒。有效期内，不会重复发送预检请求
        httpResponse.setHeader("Access-Control-Max-Age", "3600");
        // 允许所有的请求header访问，可以自定义设置任意请求头信息
        httpResponse.addHeader("Access-Control-Allow-Headers",
                "Accept,authorization,Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");// 是否允许用户发送、处理cookie

        // 如果额外设置自己的头需要在这定义
        // httpResponse.setHeader("Access-Control-Expose-Headers", "sessionid");
        filterChain.doFilter(servletRequest, httpResponse);
    }
}
