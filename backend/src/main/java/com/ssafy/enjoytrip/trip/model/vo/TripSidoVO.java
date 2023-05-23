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
    private int sidoCode;

    @Column(name="sido_name")
    private String sidoName;


    public TripSidoVO() {
    }

    public TripSidoVO( int sidoCode, String sidoName) {
        setSidoCode(sidoCode);
        setSidoName(sidoName);
    }

    public void setSidoCode(int sidoCode){
        if(sidoCode>=0){//확인 필요
            this.sidoCode=sidoCode;
        }
    }
    public int getSidoCode(){
        return sidoCode;
    }

    public void setSidoName(String sidoName){
        if(sidoName!=null){
            this.sidoName=sidoName;
        }
    }
    public String getSidoName(){
        return sidoName;
    }
}
