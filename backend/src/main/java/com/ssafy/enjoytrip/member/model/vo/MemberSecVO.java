package com.ssafy.enjoytrip.member.model.vo;

import javax.persistence.*;

//null일 경우 예외 던지기
@Entity(name="membersec")
public class MemberSecVO {

    @Id
    private String id;
    private String salt;

    @OneToOne
    @JoinColumn(name="id",referencedColumnName = "id",foreignKey = @ForeignKey(name="fk_membersec_member"))
    private MemberVO member;

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
