package com.ssafy.enjoytrip.member.model.dto;

import com.ssafy.enjoytrip.member.util.LoginException;
import com.ssafy.enjoytrip.util.StringUtils;

public class MemberLoginDto {
    private String id;
    private String password;
    public MemberLoginDto(){}

    public MemberLoginDto(String id, String password) throws LoginException {
        setId(id);
        setPassword(password);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws LoginException {
        if(!StringUtils.isBlank(id)) {
            this.id = id;
        }
        else{
            throw new LoginException("아이디를 입력해주세요");
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws LoginException {
        if(!StringUtils.isBlank(password)) {
            this.password = password;
        }
        else{
            throw new LoginException("비밀번호를 입력해주세요");
        }
    }
}
