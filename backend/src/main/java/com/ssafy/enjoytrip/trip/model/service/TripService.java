package com.ssafy.enjoytrip.trip.model.service;

import com.ssafy.enjoytrip.member.util.InfoCheckException;
import com.ssafy.enjoytrip.trip.model.dto.TripSidoDto;
import com.ssafy.enjoytrip.trip.model.repository.TripRepository;
import com.ssafy.enjoytrip.trip.model.vo.TripSidoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TripService {

    public TripSidoDto getSidoList(String token) throws InfoCheckException;
}
