package com.ssafy.enjoytrip.member.model.vo;

import javax.persistence.*;

//null일 경우 예외 던지기
@Entity(name="member")
public class MemberVO {
    @Id
    @Column(name="id")
    private String id;
    @Column(name="password")
    private String password;
    @Column(name="name")
    private String name;

    @OneToOne(mappedBy="member")
    private MemberSecVO memberSec;


    public MemberVO() {  }
    public MemberVO(String id,String pw,String name){
        setId(id);
        setPassword(pw);
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

    public void setPassword(String password){
        if(password!=null){
            this.password=password;
        }
    }
    public String getPassword(){
        return password;
    }

    public void setName(String name){
        if(name!=null){
            this.name=name;
        }
    }
    public String getName(){
        return name;
    }

    public MemberSecVO getMemberSec() {
        return memberSec;
    }

    public void setMemberSec(MemberSecVO memberSec) {
        this.memberSec = memberSec;
    }
}
