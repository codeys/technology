package com.technical.terchnicalsummary.config;
/*
 * @ClassName ServletConfig
 * @Description 过滤器、拦截器配置类
 * @Author shuai_yu
 * @Date 2021/9/20 8:46
 **/

import com.technical.terchnicalsummary.config.filter.CustomFilter;
import com.technical.terchnicalsummary.config.interceptor.CustomInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ServletConfig implements WebMvcConfigurer {

    @Bean
    public FilterRegistrationBean registerFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new CustomFilter());
        filterRegistrationBean.addUrlPatterns("/update");
        filterRegistrationBean.setName("customFilter");
        //过滤器执行顺序
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CustomInterceptor()).addPathPatterns("/aop");
    }
}
