package com.ssafy.enjoytrip.member.model.repository;

import com.ssafy.enjoytrip.member.model.vo.MemberSecVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberSecRepository extends JpaRepository<MemberSecVO,String> {

//    String getSalt(String id);
//
//    void insertSec(MemberSecVO memberSecVO);
}
