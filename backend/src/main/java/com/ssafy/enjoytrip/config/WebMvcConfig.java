package com.ssafy.enjoytrip.config;

import com.ssafy.enjoytrip.interceptor.JWTInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    private final JWTInterceptor jwtInterceptor;
    private final String[] JWT_WHITE_LIST = {"/user/login","/user/regist"};

    public WebMvcConfig(JWTInterceptor jwtInterceptor) {
        this.jwtInterceptor = jwtInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/**","**")
                .order(1)
                .excludePathPatterns(JWT_WHITE_LIST);
    }
}
