package com.ssafy.enjoytrip.member.model.vo;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

//null일 경우 예외 던지기
@Entity(name="membersec")
public class MemberSecVO {

    @Id
    private String id;
    private String salt;
    private Integer try_count;
    private LocalDateTime blocked_time;

    @OneToOne
    @JoinColumn(name="id",referencedColumnName = "id",foreignKey = @ForeignKey(name="fk_membersec_member"))
    private MemberVO member;

    public MemberSecVO(){}
    public MemberSecVO(String id,String salt){
        setId(id);
        setSalt(salt);
        setTry_count(0);
        setBlocked_time(null);
    }
    public MemberSecVO(String id,String salt,Integer try_count,LocalDateTime blocked_time){
        setId(id);
        setSalt(salt);
        setTry_count(try_count);
        setBlocked_time(blocked_time);
    }

    public Integer getTry_count() {
        return try_count;
    }

    public void setTry_count(Integer try_count) {
        this.try_count = try_count;
    }

    public LocalDateTime getBlocked_time() {
        return blocked_time;
    }

    public void setBlocked_time(LocalDateTime blocked_time) {
        this.blocked_time = blocked_time;
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

    /**
     * 로그인 시도 횟수를 업데이트하는 메소드.
     * 만약 3회 이상 실패해버리면 1분동안 block
     */
    public void updateTryCount(){
        this.try_count++;
        if(this.try_count>3){
            setTry_count(0);
            setBlocked_time(LocalDateTime.now().plusMinutes(1));
        }
    }

    /**
    * 로그인성공시 trycount와 blockedTime을 null로 초기화
    * */
    public void loginSuccess(){
        setBlocked_time(null);
        setTry_count(0);
    }
}
