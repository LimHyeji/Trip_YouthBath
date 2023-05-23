package com.ssafy.enjoytrip.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.enjoytrip.util.ApiUtils;
import com.ssafy.enjoytrip.util.jwt.JWTProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JWTInterceptor implements HandlerInterceptor {
    private final JWTProvider jwtProvider;
    private final ObjectMapper mapper;

    public JWTInterceptor(JWTProvider jwtProvider,ObjectMapper mapper) {
        this.jwtProvider = jwtProvider;
        this.mapper=mapper;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getMethod().equals("OPTIONS")){
            return true;//CORS 체크하러 오는건 통과
        }
        
        
        String authorization = request.getHeader("Authorization");
        if(authorization!=null && authorization.startsWith("Bearer") && authorization.split(" ").length == 2){
            String[] split = authorization.split(" ");
            String accessToken = split[1];

            if(jwtProvider.isValidToken(accessToken)) {//토큰이 헤더에 존재하고, 규칙에 맞게 잘 전달이 된 valid한 토큰이라면 true
                request.setAttribute("accessToken",accessToken);//request에 accessToken을 넣어줌
                return true;
            }
        }

        //아닌 모든 경우는 not authenticated
        ResponseEntity<ApiUtils.ApiResult<?>> notAuthenticated = ApiUtils.error("Not Authenticated", HttpStatus.UNAUTHORIZED);
        response.getWriter().write(mapper.writeValueAsString(notAuthenticated.getBody()));
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        return false;
    }

}
