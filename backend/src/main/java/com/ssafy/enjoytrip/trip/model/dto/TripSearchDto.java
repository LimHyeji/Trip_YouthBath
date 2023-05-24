package com.ssafy.enjoytrip.trip.model.dto;

public class TripSearchDto {
    private int sidoCode;

    private int gugunCode;

    private int contentTypeId;

    public TripSearchDto(){}

    public TripSearchDto(int sidoCode,int gugunCode,int contentTypeId){
     setSidoCode(sidoCode);
     setGugunCode(gugunCode);
     setContentTypeId(contentTypeId);
    }

    public void setSidoCode(int sidoCode){
        if(sidoCode>=0){
            this.sidoCode=sidoCode;
        }
    }
    public int getSidoCode(){
        return sidoCode;
    }

    public void setGugunCode(int gugunCode){
        if(gugunCode>=0){
            this.gugunCode=gugunCode;
        }
    }
    public int getGugunCode(){
        return gugunCode;
    }

    public void setContentTypeId(int contentTypeId){
        if(contentTypeId>=0){
            this.contentTypeId=contentTypeId;
        }
    }

    public int getContentTypeId(){
        return contentTypeId;
    }
}
