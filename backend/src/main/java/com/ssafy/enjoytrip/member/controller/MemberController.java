package com.ssafy.enjoytrip.member.controller;

import com.ssafy.enjoytrip.member.model.dto.MemberInfoDto;
import com.ssafy.enjoytrip.member.model.dto.MemberJoinDto;
import com.ssafy.enjoytrip.member.model.dto.MemberLoginDto;
import com.ssafy.enjoytrip.member.model.service.MemberService;
import com.ssafy.enjoytrip.member.model.vo.MemberVO;
import com.ssafy.enjoytrip.member.util.InfoCheckException;
import com.ssafy.enjoytrip.member.util.JoinException;
import com.ssafy.enjoytrip.member.util.LoginException;
import com.ssafy.enjoytrip.util.dto.Token;
import com.ssafy.enjoytrip.util.jwt.JWTProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.ssafy.enjoytrip.util.ApiUtils.*;

@RestController
@RequestMapping(value="/user"
//        ,consumes = MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE
)
@CrossOrigin(origins="http://localhost:8080",allowCredentials = "true",allowedHeaders = "*")
public class MemberController {
    private Logger log = LoggerFactory.getLogger(MemberController.class);
    private final MemberService memberService;
    private final JWTProvider jwtProvider;
    public MemberController(MemberService memberService,JWTProvider jwtProvider){
        this.memberService = memberService;
        this.jwtProvider=jwtProvider;
    }
    @PostMapping(value = "/regist")
    public ResponseEntity<ApiResult<String>> regist(@RequestBody MemberJoinDto memberJoinDto) throws JoinException {
        memberService.regist(memberJoinDto);
        log.info("joinDto = {}",memberJoinDto);
        return success("회원가입 성공", HttpStatus.CREATED);
    }

    @PostMapping(value="/login")
    public ResponseEntity<ApiResult<Token>> login(@RequestBody MemberLoginDto dto) throws LoginException {
        return success(memberService.login(dto),HttpStatus.OK);
    }
    
    //이부분은 좀 더 손볼 필요가있음
    @GetMapping
    public ResponseEntity<ApiResult<MemberInfoDto>> getInfo(@RequestHeader("Authorization") String authorization) throws InfoCheckException{
        try {
            String accessToken = authorization.split(" ")[1];
            MemberVO memberVO = jwtProvider.parseInfo(accessToken);

            return success(new MemberInfoDto(memberVO.getId(),memberVO.getName()),HttpStatus.OK);
        }catch(Exception e){
            throw new InfoCheckException("오류");
        }
    }
}
