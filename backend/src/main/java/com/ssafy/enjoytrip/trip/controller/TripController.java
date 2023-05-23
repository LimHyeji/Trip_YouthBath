package com.ssafy.enjoytrip.trip.controller;

import com.ssafy.enjoytrip.member.controller.MemberController;
import com.ssafy.enjoytrip.member.util.InfoCheckException;
import com.ssafy.enjoytrip.trip.model.dto.TripGugunDto;
import com.ssafy.enjoytrip.trip.model.dto.TripSidoDto;
import com.ssafy.enjoytrip.trip.model.service.TripService;
import com.ssafy.enjoytrip.trip.model.vo.TripSidoVO;
import com.ssafy.enjoytrip.util.ApiUtils;
import com.ssafy.enjoytrip.util.jwt.JWTProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.ssafy.enjoytrip.util.ApiUtils.success;

@RestController
@RequestMapping(value="/trip")
@CrossOrigin(origins="http://localhost:8080",methods={RequestMethod.OPTIONS,RequestMethod.GET,RequestMethod.POST},allowCredentials = "true",allowedHeaders = "*")
public class TripController {

    private Logger log = LoggerFactory.getLogger(TripController.class);

    private final TripService tripService;

    public TripController(TripService tripService){
        this.tripService=tripService;
    }

    @GetMapping(value="/sido")
    public ResponseEntity<ApiUtils.ApiResult<TripSidoDto>> getSidoList( @RequestHeader("Authorization") String authorization) throws InfoCheckException{
        String token=authorization.split(" ")[1];
        return success(tripService.getSidoList(token), HttpStatus.OK);
    }

    @GetMapping(value="/gugun/{sidoCode}")
    public ResponseEntity<ApiUtils.ApiResult<TripGugunDto>> getGugunList( @RequestHeader("Authorization") String authorization, @PathVariable(required = true,name="sidoCode")int sido_code) throws InfoCheckException{
        String token=authorization.split(" ")[1];
        return success(tripService.getGugunList(token,sido_code),HttpStatus.OK);
    }
}

