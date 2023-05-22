package com.ssafy.enjoytrip.member.model.dto;

import com.ssafy.enjoytrip.member.util.UpdateException;
import com.ssafy.enjoytrip.util.StringUtils;

public class MemberUpdateDto {
    private String name;
    public MemberUpdateDto(){}

    public MemberUpdateDto(String name) throws UpdateException {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws UpdateException {
        if(StringUtils.isBlank(name)){
            throw new UpdateException("이름이 비어있습니다.");
        }
        this.name = name;
    }
}
