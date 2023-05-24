package com.ssafy.enjoytrip.trip.model.dto;

import com.ssafy.enjoytrip.trip.model.vo.TripVO;

import java.util.List;

public class TripListDto {

    private List<TripVO> tripList;

    public TripListDto() {}

    public TripListDto(List<TripVO> tripList){
        setTripList(tripList);
    }

    public void setTripList(List<TripVO> tripList){
        if(tripList!=null){
            this.tripList=tripList;
        }
    }
    public List<TripVO> getTripList(){
        return tripList;
    }
}
