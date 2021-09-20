package com.technical.terchnicalsummary.config.filter;
/*
 * @ClassName CustomFilter
 * @Description 自定义过滤器
 * @Author shuai_yu
 * @Date 2021/9/20 8:41
 **/


import javax.servlet.*;
import java.io.IOException;

public class CustomFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Execute time = " + (System.currentTimeMillis() - start));
    }

    @Override
    public void destroy() {

    }
}
