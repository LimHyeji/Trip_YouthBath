package com.ssafy.enjoytrip.trip.model.repository;

import com.ssafy.enjoytrip.trip.model.vo.TripVO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripRepository extends JpaRepository<TripVO,Integer> {

    List<TripVO> findAllBySidoCodeAndGugunCodeAndContentTypeId(int sidoCode,int gugunCode,int contentTypeId);

}
