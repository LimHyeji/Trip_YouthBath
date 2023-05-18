package com.ssafy.enjoytrip.member.model.service;

import com.ssafy.enjoytrip.member.model.repository.MemberRepository;
import com.ssafy.enjoytrip.member.model.repository.MemberSecRepository;
import com.ssafy.enjoytrip.member.model.vo.MemberSecVO;
import com.ssafy.enjoytrip.member.model.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberSecRepository memberSecRepository;

    public void regist(MemberVO memberVO) {
        String salt=null;
        //salt 구하기
        MemberSecVO memberSecVO=new MemberSecVO(memberVO.getId(),salt);
        memberSecRepository.insertSec(memberSecVO);

        memberRepository.regist(memberVO);
    }

    public String login(MemberVO memberVO) {
        String salt=memberSecRepository.getSalt(memberVO.getId());
        //비밀번호 암호화
        //비밀번호 세팅
        return memberRepository.login(memberVO);
    }
}
