package com.ssafy.enjoytrip.trip.model.service;

import com.ssafy.enjoytrip.member.model.repository.MemberRepository;
import com.ssafy.enjoytrip.member.model.vo.MemberVO;
import com.ssafy.enjoytrip.member.util.InfoCheckException;
import com.ssafy.enjoytrip.trip.model.dto.TripGugunDto;
import com.ssafy.enjoytrip.trip.model.dto.TripSidoDto;
import com.ssafy.enjoytrip.trip.model.repository.TripGugunRepository;
import com.ssafy.enjoytrip.trip.model.repository.TripSidoRepository;
import com.ssafy.enjoytrip.trip.model.vo.TripGugunVO;
import com.ssafy.enjoytrip.trip.model.vo.TripSidoVO;
import com.ssafy.enjoytrip.util.jwt.JWTException;
import com.ssafy.enjoytrip.util.jwt.JWTProvider;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImpl implements TripService{

    private final TripSidoRepository tripSidoRepository;

    private final TripGugunRepository tripGugunRepository;

    private final MemberRepository memberRepository;

    private final JWTProvider jwtProvider;

    public TripServiceImpl(TripSidoRepository tripSidoRepository,TripGugunRepository tripGugunRepository, MemberRepository memberRepository, JWTProvider jwtProvider){
        this.tripSidoRepository = tripSidoRepository;
        this.tripGugunRepository=tripGugunRepository;
        this.memberRepository=memberRepository;
        this.jwtProvider=jwtProvider;
    }

    public TripSidoDto getSidoList(String token) throws InfoCheckException {
        try{
            MemberVO memberInfo=jwtProvider.parseInfo(token);
            MemberVO memberVO=memberRepository.findById(memberInfo.getId()).orElseThrow(()->new InfoCheckException("유저가 존재하지 않습니다"));

            List<TripSidoVO> sidoList= tripSidoRepository.findAll();
            return new TripSidoDto(sidoList);
        }catch(JWTException e){
            throw new InfoCheckException(e.getMessage());
        }
    }

    public TripGugunDto getGugunList(String token, int sido_code) throws InfoCheckException {
        try{
            MemberVO memberInfo=jwtProvider.parseInfo(token);
            MemberVO memberVO=memberRepository.findById(memberInfo.getId()).orElseThrow(()->new InfoCheckException("유저가 존재하지 않습니다"));

            List<TripGugunVO> gugunList= tripGugunRepository.findBySidoCode(sido_code);
            return new TripGugunDto(gugunList);
        }catch(JWTException e){
            throw new InfoCheckException(e.getMessage());
        }
    }
}
