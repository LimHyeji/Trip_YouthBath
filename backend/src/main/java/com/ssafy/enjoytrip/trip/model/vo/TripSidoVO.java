package com.ssafy.enjoytrip.trip.model.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="sido")
@Table(name="sido")
public class TripSidoVO {

    @Id
    @Column(name="sido_code")
    private int sido_code;

    @Column(name="sido_name")
    private String sido_name;


    public TripSidoVO() {
    }

    public TripSidoVO( int sido_code, String sido_name) {
        setSido_code(sido_code);
        setSido_Name(sido_name);
    }

    public void setSido_code(int sido_code){
        if(sido_code>=0){//확인 필요
            this.sido_code=sido_code;
        }
    }
    public int getSido_code(){
        return sido_code;
    }

    public void setSido_Name(String sido_name){
        if(sido_name!=null){
            this.sido_name=sido_name;
        }
    }
    public String getSido_name(){
        return sido_name;
    }
}
