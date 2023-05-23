package com.ssafy.enjoytrip.trip.model.repository;

import com.ssafy.enjoytrip.trip.model.dto.TripGugunDto;
import com.ssafy.enjoytrip.trip.model.vo.TripGugunVO;
import com.ssafy.enjoytrip.trip.model.vo.TripSidoVO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripGugunRepository extends JpaRepository<TripGugunVO,Integer> {

    public List<TripGugunVO> findBySidoCode(int sido_code);
}
