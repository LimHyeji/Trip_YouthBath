package com.ssafy.enjoytrip.config;

import com.ssafy.enjoytrip.filter.xss.XSSFilter;
import com.ssafy.enjoytrip.interceptor.JWTInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    private final JWTInterceptor jwtInterceptor;
    private final String[] JWT_WHITE_LIST = {"/user/login","/user/regist","/auth/**"};

    public WebMvcConfig(JWTInterceptor jwtInterceptor) {
        this.jwtInterceptor = jwtInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(JWT_WHITE_LIST);
    }

    @Bean
    public FilterRegistrationBean<XSSFilter> registrationBean(){
        FilterRegistrationBean<XSSFilter> registrationBean=new FilterRegistrationBean<>(new XSSFilter());
        registrationBean.setOrder(1);
        registrationBean.setName("xss-filter");
        registrationBean.addUrlPatterns("/*");

        return registrationBean;
    }
}
