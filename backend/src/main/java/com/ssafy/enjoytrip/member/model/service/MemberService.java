package com.ssafy.enjoytrip.member.model.service;

import com.ssafy.enjoytrip.member.model.dto.*;
import com.ssafy.enjoytrip.member.model.vo.MemberSecVO;
import com.ssafy.enjoytrip.member.model.vo.MemberVO;
import com.ssafy.enjoytrip.member.util.*;
import com.ssafy.enjoytrip.util.dto.Token;
import com.ssafy.enjoytrip.util.encrypt.OpenCrypt;
import com.ssafy.enjoytrip.util.jwt.JWTException;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.UUID;

public interface MemberService {
    public void regist(MemberJoinDto dto) throws JoinException;

    //후에 로그인 시도 횟수 로직 추가
    public Token login(MemberLoginDto dto) throws LoginException ;

    public MemberInfoDto getInfo(String token) throws InfoCheckException ;

    public boolean secondaryAuthentication(String token, SecondaryAuthenticationDto dto) throws InfoCheckException ;

    public MemberInfoDto updateMember(String token, MemberUpdateDto dto) throws UpdateException;

    public Boolean deleteMember(String token) throws DeleteException;
}
