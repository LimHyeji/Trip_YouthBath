package com.ssafy.enjoytrip.trip.model.service;

import com.ssafy.enjoytrip.member.model.repository.MemberRepository;
import com.ssafy.enjoytrip.member.model.vo.MemberVO;
import com.ssafy.enjoytrip.member.util.InfoCheckException;
import com.ssafy.enjoytrip.trip.model.dto.TripSidoDto;
import com.ssafy.enjoytrip.trip.model.repository.TripRepository;
import com.ssafy.enjoytrip.trip.model.vo.TripSidoVO;
import com.ssafy.enjoytrip.util.jwt.JWTException;
import com.ssafy.enjoytrip.util.jwt.JWTProvider;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImpl implements TripService{

    private final TripRepository tripRepository;

    private final MemberRepository memberRepository;

    private final JWTProvider jwtProvider;

    public TripServiceImpl(TripRepository tripRepository,MemberRepository memberRepository, JWTProvider jwtProvider){
        this.tripRepository=tripRepository;
        this.memberRepository=memberRepository;
        this.jwtProvider=jwtProvider;
    }

    public TripSidoDto getSidoList(String token) throws InfoCheckException {
        try{
            MemberVO memberInfo=jwtProvider.parseInfo(token);
            MemberVO memberVO=memberRepository.findById(memberInfo.getId()).orElseThrow(()->new InfoCheckException("유저가 존재하지 않습니다"));

            List<TripSidoVO> sidoList=tripRepository.findAll();
            return new TripSidoDto(sidoList);
        }catch(JWTException e){
            throw new InfoCheckException(e.getMessage());
        }
    }
}
