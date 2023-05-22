package com.ssafy.enjoytrip.member.controller;

import com.ssafy.enjoytrip.member.model.dto.*;
import com.ssafy.enjoytrip.member.model.service.MemberService;
import com.ssafy.enjoytrip.member.model.service.MemberServiceImpl;
import com.ssafy.enjoytrip.member.util.*;
import com.ssafy.enjoytrip.util.dto.Token;
import com.ssafy.enjoytrip.util.jwt.JWTProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static com.ssafy.enjoytrip.util.ApiUtils.*;

@RestController
@RequestMapping(value="/user"
//        ,consumes = MediaType.APPLICATION_JSON_VALUE,produces= MediaType.APPLICATION_JSON_VALUE
)
@CrossOrigin(origins="http://localhost:8080",methods={RequestMethod.OPTIONS,RequestMethod.GET,RequestMethod.POST},allowCredentials = "true",allowedHeaders = "*")
public class MemberController {
    private Logger log = LoggerFactory.getLogger(MemberController.class);
    private final MemberService memberService;
    private final JWTProvider jwtProvider;
    public MemberController(MemberService memberService, JWTProvider jwtProvider){
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

    /**
     * 여기서부터 인증이 필요한 메서드들
     * interceptor에서 jwt를 확인 및 유효성 검사
     * 확인되면 복호화되지않은 jwt토큰을 request.setAttribute로 넣어서 컨트롤러로 전달
     *
     * 컨트롤러에서는 request.getAttribute로 accessToken을 받아오면됨
     * */
    @GetMapping
    public ResponseEntity<ApiResult<MemberInfoDto>> getInfo(HttpServletRequest request) throws InfoCheckException {
//        String accessToken = (String)(request.getAttribute("accessToken"));
        String accessToken = request.getHeader("Authorization").split(" ")[1];
        return success(memberService.getInfo(accessToken),HttpStatus.OK);
    }

    /**
     * 2차인증을 하기 위한 메서드
     */
    @PostMapping("/secondary")
    public ResponseEntity<ApiResult<Boolean>> secondaryAuthentication(
            HttpServletRequest request,
            @RequestBody SecondaryAuthenticationDto dto) throws InfoCheckException{
//        String token = (String)request.getAttribute("accessToken");
        String token = request.getHeader("Authorization").split(" ")[1];
        System.out.println("token = " + token);
        boolean result = memberService.secondaryAuthentication(token,dto);
        return success(result,HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ApiResult<MemberInfoDto>> updateMember(
            HttpServletRequest request,
            @RequestBody MemberUpdateDto dto) throws UpdateException{
        String token = request.getHeader("Authorization").split(" ")[1];

        return success(memberService.updateMember(token,dto),HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<ApiResult<Boolean>> deleteMember(
            HttpServletRequest request) throws DeleteException {
        String token = request.getHeader("Authorization").split(" ")[1];

        return success(memberService.deleteMember(token),HttpStatus.OK);
    }
}
