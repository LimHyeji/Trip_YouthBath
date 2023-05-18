package com.ssafy.enjoytrip.member.controller;

import com.ssafy.enjoytrip.member.model.service.MemberService;
import com.ssafy.enjoytrip.member.model.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class MemberController {

    //jwt 코드 필요
    
    @Autowired
    MemberService memberService;

    @PostMapping("/regist")
    public void regist(MemberVO memberVO){
        memberService.regist(memberVO);
    }

    @PostMapping("/login")
    public String login(MemberVO memberVO){
        String name=memberService.login(memberVO);
        return name;
    }


}
