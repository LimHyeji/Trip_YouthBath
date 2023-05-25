package com.ssafy.enjoytrip.trip.model.service;

import com.ssafy.enjoytrip.member.util.InfoCheckException;
import com.ssafy.enjoytrip.trip.model.dto.TripGugunDto;
import com.ssafy.enjoytrip.trip.model.dto.TripSearchDto;
import com.ssafy.enjoytrip.trip.model.dto.TripSidoDto;
import com.ssafy.enjoytrip.trip.model.dto.TripListDto;

public interface TripService {

    public TripListDto getAllTripList(String token) throws InfoCheckException;

    public TripSidoDto getSidoList();

    public TripGugunDto getGugunList(int sido_code);

    public TripListDto getTripList(String token, TripSearchDto tripSearchDto) throws InfoCheckException;

}
