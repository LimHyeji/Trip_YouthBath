package com.ssafy.enjoytrip.member.model.dto;

import com.ssafy.enjoytrip.member.util.InfoCheckException;
import com.ssafy.enjoytrip.util.StringUtils;

public class SecondaryAuthenticationDto {
    private String password;

    public SecondaryAuthenticationDto() {
    }

    public SecondaryAuthenticationDto(String password) throws InfoCheckException {
        setPassword(password);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws InfoCheckException {
        if(StringUtils.isBlank(password)){
            throw new InfoCheckException("비밀번호를 입력하세요");
        }
        this.password = password;
    }
}
