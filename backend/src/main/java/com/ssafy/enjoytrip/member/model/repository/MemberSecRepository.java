package com.ssafy.enjoytrip.member.model.repository;

import com.ssafy.enjoytrip.member.model.vo.MemberSecVO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberSecRepository extends JpaRepository<MemberSecVO,String> {
    Optional<MemberSecVO> findByUuid(String uuid);
}
