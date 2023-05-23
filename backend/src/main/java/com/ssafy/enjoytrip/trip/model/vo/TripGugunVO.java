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
    private int gugun_code;

    @Column(name="gugun_name")
    private String gugun_name;

    @Column(name="sido_code")
    private int sido_code;

    public TripGugunVO() {
    }
    public TripGugunVO(int gugun_code, String gugun_name, int sido_code) {
        setGugun_code(gugun_code);
        setGugun_name(gugun_name);
        setSido_code(sido_code);
    }

    public void setGugun_code(int gugun_code) {
        if(gugun_code>=0) {//확인 필요
            this.gugun_code = gugun_code;
        }
    }
    public int getGugun_code() {
        return gugun_code;
    }

    public void setGugun_name(String gugun_name) {
        if(gugun_name!=null) {
            this.gugun_name = gugun_name;
        }
    }
    public String getGugun_name() {
        return gugun_name;
    }


    public void setSido_code(int sido_code) {
        if(sido_code>=0) {//확인 필요
            this.sido_code = sido_code;
        }
    }
    public int getSido_code() {
        return sido_code;
    }

}
