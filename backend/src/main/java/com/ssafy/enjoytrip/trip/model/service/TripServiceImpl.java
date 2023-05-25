package com.ssafy.enjoytrip.trip.model.service;

import com.ssafy.enjoytrip.member.model.repository.MemberRepository;
import com.ssafy.enjoytrip.member.model.vo.MemberVO;
import com.ssafy.enjoytrip.member.util.InfoCheckException;
import com.ssafy.enjoytrip.trip.model.dto.TripGugunDto;
import com.ssafy.enjoytrip.trip.model.dto.TripSearchDto;
import com.ssafy.enjoytrip.trip.model.dto.TripSidoDto;
import com.ssafy.enjoytrip.trip.model.dto.TripListDto;
import com.ssafy.enjoytrip.trip.model.repository.TripGugunRepository;
import com.ssafy.enjoytrip.trip.model.repository.TripSidoRepository;
import com.ssafy.enjoytrip.trip.model.repository.TripRepository;
import com.ssafy.enjoytrip.trip.model.vo.TripGugunVO;
import com.ssafy.enjoytrip.trip.model.vo.TripSidoVO;
import com.ssafy.enjoytrip.trip.model.vo.TripVO;
import com.ssafy.enjoytrip.util.jwt.JWTException;
import com.ssafy.enjoytrip.util.jwt.JWTProvider;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImpl implements TripService{

    private final TripSidoRepository tripSidoRepository;

    private final TripGugunRepository tripGugunRepository;

    private final TripRepository tripRepository;

    private final MemberRepository memberRepository;

    private final JWTProvider jwtProvider;

    public TripServiceImpl(TripSidoRepository tripSidoRepository, TripGugunRepository tripGugunRepository, TripRepository tripRepository, MemberRepository memberRepository, JWTProvider jwtProvider){
        this.tripSidoRepository = tripSidoRepository;
        this.tripGugunRepository=tripGugunRepository;
        this.tripRepository = tripRepository;
        this.memberRepository=memberRepository;
        this.jwtProvider=jwtProvider;
    }

    public TripListDto getAllTripList(String token) throws InfoCheckException {
        try {
            String id = jwtProvider.parseInfo(token).getId();
            MemberVO member = memberRepository.findById(id).orElseThrow(() -> new InfoCheckException("사용자가 존재하지 않습니다."));
            List<TripVO> tripList= tripRepository.findAll();
            return new TripListDto(tripList);
        }
        catch(JWTException e) {
            throw new InfoCheckException(e.getMessage());
        }
    }

    public TripSidoDto getSidoList() {
            List<TripSidoVO> sidoList= tripSidoRepository.findAll();
            return new TripSidoDto(sidoList);
    }

    public TripGugunDto getGugunList(int sido_code){
            List<TripGugunVO> gugunList= tripGugunRepository.findBySidoCode(sido_code);
            return new TripGugunDto(gugunList);
    }

    public TripListDto getTripList(String token, TripSearchDto tripSearchDto) throws InfoCheckException {
       try {
           String id = jwtProvider.parseInfo(token).getId();
           MemberVO member = memberRepository.findById(id).orElseThrow(() -> new InfoCheckException("사용자가 존재하지 않습니다."));
          // System.out.println(tripSearchDto.getSidoCode()+","+tripSearchDto.getGugunCode()+","+tripSearchDto.getContentTypeId());
           List<TripVO> tripList= tripRepository.findAllBySidoCodeAndGugunCodeAndContentTypeId(tripSearchDto.getSidoCode(),tripSearchDto.getGugunCode(),tripSearchDto.getContentTypeId());
            return new TripListDto(tripList);
       }
       catch(JWTException e) {
            throw new InfoCheckException(e.getMessage());
       }
    }
}
