package com.ssafy.enjoytrip.member.model.vo;

import javax.persistence.Entity;
import javax.persistence.Id;

//null일 경우 예외 던지기
@Entity(name="member")
public class MemberVO {
    @Id
    private String id;
    private String pw;
    private String name;


    public MemberVO() {  }
    public MemberVO(String id,String pw,String name){
        setId(id);
        setPw(pw);
        setName(name);
    }

    public void setId(String id){
        if(id!=null){
            this.id=id;
        }
    }
    public String getId(){
        return id;
    }

    public void setPw(String pw){
        if(pw!=null){
            this.pw=pw;
        }
    }
    public String getPw(){
        return pw;
    }

    public void setName(String name){
        if(name!=null){
            this.name=name;
        }
    }
    public String getName(){
        return name;
    }
}
