package com.ssafy.enjoytrip.trip.model.dto;

import com.ssafy.enjoytrip.trip.model.vo.TripGugunVO;

import java.util.List;

public class TripGugunDto {

    private List<TripGugunVO> gugunList;

    public TripGugunDto(){}

    public TripGugunDto(List<TripGugunVO> gugunList){
        setGugunList(gugunList);
    }

    public void setGugunList(List<TripGugunVO> gugunList){
        if(gugunList!=null){
            this.gugunList=gugunList;
        }
    }

    public List<TripGugunVO> getGugunList(){
        return gugunList;
}
}
