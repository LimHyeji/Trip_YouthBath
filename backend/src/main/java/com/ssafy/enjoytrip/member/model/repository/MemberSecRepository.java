package com.ssafy.enjoytrip.member.model.repository;

import com.ssafy.enjoytrip.member.model.vo.MemberSecVO;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberSecRepository {

    String getSalt(String id);

    void insertSec(MemberSecVO memberSecVO);
}
