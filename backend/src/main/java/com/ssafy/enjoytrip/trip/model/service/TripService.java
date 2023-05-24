package com.ssafy.enjoytrip.trip.model.service;

import com.ssafy.enjoytrip.member.util.InfoCheckException;
import com.ssafy.enjoytrip.trip.model.dto.TripGugunDto;
import com.ssafy.enjoytrip.trip.model.dto.TripSidoDto;

public interface TripService {

    public TripSidoDto getSidoList();

    public TripGugunDto getGugunList(int sido_code);
}
