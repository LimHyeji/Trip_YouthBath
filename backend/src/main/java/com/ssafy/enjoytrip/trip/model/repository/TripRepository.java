package com.ssafy.enjoytrip.trip.model.repository;

import com.ssafy.enjoytrip.trip.model.vo.TripSidoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TripRepository extends JpaRepository<TripSidoVO,Integer> {
}
