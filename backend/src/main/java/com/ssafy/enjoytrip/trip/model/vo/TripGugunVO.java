package com.ssafy.enjoytrip.trip.model.vo;

public class TripGugunVO {
    private int code;
    private String name;
    private int sidoCode;

    public TripGugunVO() {
    }
    public TripGugunVO(int code, String name, int sidoCode) {
        setCode(code);
        setName(name);
        setSidoCode(sidoCode);
    }

    public void setCode(int code) {
        if(code>=0) {//확인 필요
            this.code = code;
        }
    }
    public int getCode() {
        return code;
    }

    public void setName(String name) {
        if(name!=null) {
            this.name = name;
        }
    }
    public String getName() {
        return name;
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
