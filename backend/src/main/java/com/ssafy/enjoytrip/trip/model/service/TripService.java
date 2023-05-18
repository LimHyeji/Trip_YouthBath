package com.ssafy.enjoytrip.trip.model.service;

import com.ssafy.enjoytrip.trip.model.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripService {

    @Autowired
    TripRepository tripRepository;

}
