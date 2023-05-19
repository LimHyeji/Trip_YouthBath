package com.ssafy.enjoytrip.member.model.service;

import com.ssafy.enjoytrip.member.model.repository.MemberRepository;
import com.ssafy.enjoytrip.member.model.repository.MemberSecRepository;
import com.ssafy.enjoytrip.member.model.vo.MemberSecVO;
import com.ssafy.enjoytrip.member.model.vo.MemberVO;
import com.ssafy.enjoytrip.util.OpenCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberSecRepository memberSecRepository;

    public void regist(MemberVO memberVO) throws Exception {
        String salt = UUID.randomUUID().toString();
        String hashPw = OpenCrypt.getSHA256(memberVO.getPw(), salt);
        MemberSecVO memberSecVO=new MemberSecVO(memberVO.getId(),salt);
        memberSecRepository.insertSec(memberSecVO);
        memberVO.setPw(hashPw);
        memberRepository.regist(memberVO);
    }

    public String login(MemberVO memberVO) throws Exception {
        String salt=memberSecRepository.getSalt(memberVO.getId();
        //비밀번호 암호화
        String hashPw = OpenCrypt.getSHA256(memberVO.getPw(), salt);
        //비밀번호 세팅
        memberVO.setPw(hashPw);
        return memberRepository.login(memberVO);
    }
}
