package com.ssafy.enjoytrip.trip.model.vo;

public class TripSidoVO {
    private String name;
    private int code;

    public TripSidoVO() {
    }

    public TripSidoVO(String name, int code) {
        setName(name);
        setCode(code);
    }

    public void setName(String name){
        if(name!=null){
            this.name=name;
        }
    }
    public String getName(){
        return name;
    }

    public void setCode(int code){
        if(code>=0){//확인 필요
            this.code=code;
        }
    }
    public int getCode(){
        return code;
    }
}
