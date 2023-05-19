package com.ssafy.enjoytrip.member.model.vo;

import javax.persistence.Entity;
import javax.persistence.Id;

//null일 경우 예외 던지기
@Entity(name="memberSec")
public class MemberSecVO {

    @Id
    private String id;
    private String salt;

    public MemberSecVO(){}
    public MemberSecVO(String id,String salt){
        setId(id);
        setSalt(salt);
    }

    public void setId(String id){
        if(id!=null){
            this.id=id;
        }
    }
    public String getId(){
        return id;
    }

    public void setSalt(String salt){
        if(salt!=null){
            this.salt=salt;
        }
    }
    public String getSalt(){
        return salt;
    }
}
