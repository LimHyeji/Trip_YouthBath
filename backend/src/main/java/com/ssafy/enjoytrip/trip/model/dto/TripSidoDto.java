package com.ssafy.enjoytrip.trip.model.dto;

import com.ssafy.enjoytrip.trip.model.vo.TripSidoVO;

import java.util.List;

public class TripSidoDto {

    private List<TripSidoVO> sidoList;

    public TripSidoDto(){
    }

    public TripSidoDto(List<TripSidoVO> sidoList) {
        setSidoList(sidoList);
    }

    public void setSidoList(List<TripSidoVO> sidoList){
        if(sidoList!=null){
            this.sidoList=sidoList;
        }
    }

    public List<TripSidoVO> getSidoList(){
        return sidoList;
    }

}
