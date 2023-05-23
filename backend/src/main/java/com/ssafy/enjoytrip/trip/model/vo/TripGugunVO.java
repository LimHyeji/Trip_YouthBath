package com.ssafy.enjoytrip.trip.model.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="gugun")
@Table(name="gugun")
public class TripGugunVO {

    @Id
    @Column(name="gugun_code")
    private int gugunCode;

    @Column(name="gugun_name")
    private String gugunName;

    @Column(name="sido_code")
    private int sidoCode;

    public TripGugunVO() {
    }
    public TripGugunVO(int gugunCode, String gugunName, int sidoCode) {
        setGugunCode(gugunCode);
        setGugunName(gugunName);
        setSidoCode(sidoCode);
    }

    public void setGugunCode(int gugunCode) {
        if(gugunCode>=0) {//확인 필요
            this.gugunCode = gugunCode;
        }
    }
    public int getGugunCode() {
        return gugunCode;
    }

    public void setGugunName(String gugunName) {
        if(gugunName!=null) {
            this.gugunName = gugunName;
        }
    }
    public String getGugunName() {
        return gugunName;
    }


    public void setSidoCode(int sidoCode) {
        if(sidoCode>=0) {//확인 필요
            this.sidoCode = sidoCode;
        }
    }
    public int getSidoCode() {
        return sidoCode;
    }

}
