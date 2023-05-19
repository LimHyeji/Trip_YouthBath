package com.ssafy.enjoytrip.member.controller;

import com.ssafy.enjoytrip.member.model.dto.MemberJoinDto;
import com.ssafy.enjoytrip.member.model.dto.MemberLoginDto;
import com.ssafy.enjoytrip.member.model.service.MemberService;
import com.ssafy.enjoytrip.member.util.JoinException;
import com.ssafy.enjoytrip.member.util.LoginException;
import com.ssafy.enjoytrip.util.dto.Token;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.ssafy.enjoytrip.util.ApiUtils.*;

@Controller
@RequestMapping("/user")
public class MemberController {
    private final MemberService memberService;
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
    @PostMapping(value = "/regist",consumes = MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResult<String>> regist(@RequestBody MemberJoinDto memberJoinDto) throws JoinException {
        memberService.regist(memberJoinDto);
        return success("회원가입 성공", HttpStatus.CREATED);
    }

    @PostMapping(value="/login",consumes = MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResult<Token>> login(@RequestBody MemberLoginDto dto) throws LoginException {
        return success(memberService.login(dto),HttpStatus.OK);
    }
}
