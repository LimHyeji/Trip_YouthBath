package com.ssafy.enjoytrip.trip.controller;

import com.ssafy.enjoytrip.trip.model.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TripController {

    @Autowired
    TripService tripService;

}
