package com.ssafy.enjoytrip.trip.model.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="attraction_info")
@Table(name="attraction_info")
public class TripVO {

    @Id
    @Column(name="content_id")
    private int contentId;

    @Column(name="content_type_id")
    private int contentTypeId;

    @Column(name="title")
    private String title;

    @Column(name="addr1")
    private String addr1;

    @Column(name="addr2")
    private String addr2;

    @Column(name="zipcode")
    private String zipCode;

    @Column(name="first_image")
    private String firstImage;

    @Column(name="sido_code")
    private int sidoCode;

    @Column(name="gugun_code")
    private int gugunCode;

    @Column(name="latitude")
    private double latitude;

    @Column(name="longitude")
    private double longitude;

    public TripVO() { }
    public TripVO(int contentId,int contentTypeId, String title,String addr1,String addr2,String zipCode,String firstImage,int sidoCode, int gugunCode, double latitude,double longitude){
        setContentId(contentId);
        setContentTypeId(contentTypeId);
        setTitle(title);
        setAddr1(addr1);
        setAddr2(addr2);
        setZipCode(zipCode);
        setFirstImage(firstImage);
        setSidoCode(sidoCode);
        setGugunCode(gugunCode);
        setLatitude(latitude);
        setLongitude(longitude);
    }

    public void setContentId(int contentId){
        if(contentId>=0){
            this.contentId=contentId;
        }
    }
    public int getContentId(){
        return contentId;
    }

    public void setContentTypeId(int contentTypeId){
        if(contentTypeId>=0){
            this.contentTypeId=contentTypeId;
        }
    }
    public int getContentTypeId(){
        return contentTypeId;
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
