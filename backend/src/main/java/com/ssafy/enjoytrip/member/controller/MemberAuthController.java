package com.ssafy.enjoytrip.member.controller;

import com.ssafy.enjoytrip.member.model.service.MemberService;
import com.ssafy.enjoytrip.member.util.InfoCheckException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 2차 인증과 관련된 컨트롤러입니다.
 *
 * */
@Controller
public class MemberAuthController {
    private final MemberService memberService;

    public MemberAuthController(MemberService memberService) {
        this.memberService = memberService;
    }



    @GetMapping("/auth/{uuid}")
    public String auth(@PathVariable("uuid") String uuid) throws InfoCheckException {
        memberService.emailAuth(uuid);
        return "redirect:http://localhost:8080/member/login";
    }
}
