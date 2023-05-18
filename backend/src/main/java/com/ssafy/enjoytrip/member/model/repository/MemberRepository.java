package com.ssafy.enjoytrip.member.model.repository;

import com.ssafy.enjoytrip.member.model.vo.MemberVO;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository {
    public void regist(MemberVO memberVO);

    String login(MemberVO memberVO);

}
