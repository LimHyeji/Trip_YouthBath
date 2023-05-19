package com.ssafy.enjoytrip.member.model.repository;

import com.ssafy.enjoytrip.member.model.vo.MemberVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberVO,String> {
    public void regist(MemberVO memberVO);

    String login(MemberVO memberVO);

}
