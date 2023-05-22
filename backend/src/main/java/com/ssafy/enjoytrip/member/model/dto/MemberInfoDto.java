package com.ssafy.enjoytrip.member.model.dto;

import com.ssafy.enjoytrip.member.util.InfoCheckException;
import com.ssafy.enjoytrip.util.StringUtils;

/*
*
* 정보를 클라이언트로 넘겨주기 위한 dto
*
* */
public class MemberInfoDto {
    private String id;
    private String name;

    public MemberInfoDto() {
    }

    public MemberInfoDto(String id, String name) throws InfoCheckException {
        setId(id);
        setName(name);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws InfoCheckException {
        if(StringUtils.isBlank(id)){
            throw new InfoCheckException("아이디가 없습니다.");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws InfoCheckException {
        if(StringUtils.isBlank(name)){
            throw new InfoCheckException("이름이 없습니다.");
        }
        this.name = name;
    }
}
