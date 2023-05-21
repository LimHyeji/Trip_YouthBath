package com.ssafy.enjoytrip.member.model.dto;

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

    public MemberInfoDto(String id, String name) {
        setId(id);
        setName(name);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
