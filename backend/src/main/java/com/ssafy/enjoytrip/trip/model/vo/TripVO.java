package com.ssafy.enjoytrip.trip.model.vo;

public class TripVO {

    private String title;
    private String addr1;
    private String addr2;
    private String zipCode;
    private String firstImage;
    private double latitude;
    private double longitude;

    public TripVO() { }
    public TripVO(String title,String addr1,String addr2,String zipCode,String firstImage,double latitude,double longitude){
        setTitle(title);
        setAddr1(addr1);
        setAddr2(addr2);
        setZipCode(zipCode);
        setFirstImage(firstImage);
        setLatitude(latitude);
        setLongitude(longitude);
    }

    public void setTitle(String title){
        if(title!=null){
            this.title=title;
        }
    }
    public String getTitle(){
        return title;
    }

    public void setAddr1(String addr1){
        if(addr1!=null){
            this.addr1=addr1;
        }
    }
    public String getAddr1(){
        return addr1;
    }

    public void setAddr2(String addr2){
        if(addr2!=null){
            this.addr2=addr2;
        }
    }
    public String getAddr2(){
        return addr2;
    }

    public void setZipCode(String zipCode){
        if(zipCode!=null){
            this.zipCode=zipCode;
        }
    }
    public String getZipCode(){
        return zipCode;
    }

    public void setFirstImage(String firstImage){
        if(firstImage!=null){
            this.firstImage=firstImage;
        }
    }
    public String getFirstImage(){
        return firstImage;
    }

    public void setLatitude(double latitude){
        if(latitude>=0){
            this.latitude=latitude;
        }
    }
    public double getLatitude(){
        return latitude;
    }

    public void setLongitude(double longitude){
        if(longitude>=0){
            this.longitude=longitude;
        }
    }

}
