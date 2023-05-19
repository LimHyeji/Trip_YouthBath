package com.ssafy.enjoytrip.member.model.service;

import com.ssafy.enjoytrip.member.model.dto.MemberJoinDto;
import com.ssafy.enjoytrip.member.model.dto.MemberLoginDto;
import com.ssafy.enjoytrip.member.model.repository.MemberRepository;
import com.ssafy.enjoytrip.member.model.repository.MemberSecRepository;
import com.ssafy.enjoytrip.member.model.vo.MemberSecVO;
import com.ssafy.enjoytrip.member.model.vo.MemberVO;
import com.ssafy.enjoytrip.member.util.JoinException;
import com.ssafy.enjoytrip.member.util.LoginException;
import com.ssafy.enjoytrip.util.encrypt.OpenCrypt;
import com.ssafy.enjoytrip.util.dto.Token;
import com.ssafy.enjoytrip.util.jwt.JWTProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    private final MemberSecRepository memberSecRepository;
    private final JWTProvider jwtProvider;


    public MemberService(MemberRepository memberRepository, MemberSecRepository memberSecRepository, JWTProvider jwtProvider){
        this.memberSecRepository=memberSecRepository;
        this.memberRepository=memberRepository;
        this.jwtProvider=jwtProvider;
    }

    //이메일중복을 피하기위해 serializable로 격리수준 upgrade
    //또한 member테이블과 membersec테이블에 한 트랜잭션 범위안에 동시에 저장되거나 동시에 저장되지 않아야함
    @Transactional(isolation = Isolation.SERIALIZABLE,rollbackFor = Exception.class)
    public void regist(MemberJoinDto dto) throws JoinException {
        //비밀번호와 비밀번호 확인이 일치하는지 체크
        if(!dto.getPassword().equals(dto.getPasswordCheck())){
            throw new JoinException("비밀번호를 다시 확인해주세요");
        }

        //이메일 중복 확인, 존재하면 throw exception
        Optional<MemberVO> existMember = memberRepository.findById(dto.getId());
        if(existMember.isPresent()){
            throw new JoinException("이미 존재하는 회원입니다.");
        }


        //비밀번호 유효성 검사 마지막단계
        //아이디와 중복된 3자리 이상의 문자열이 있는지 판단

        boolean isContain=false;
        for(int len=3;len<dto.getId().length();len++){
            for(int start = 0;start+len<dto.getId().length();start++){
                String subStr = dto.getId().substring(start,start+len);

                if(dto.getPassword().contains(subStr)){
                    isContain=true;
                    break;
                }
            }
            if(isContain) break;
        }

        if(isContain) throw new JoinException("아이디와 3자리 이상 중복될 수 없습니다.");


        //유효성 검사가 끝났으니 회원가입 진행
        try {
            String salt = UUID.randomUUID().toString();
            String hashPw = OpenCrypt.getSHA256(dto.getPassword(), salt);

            MemberVO memberVo = new MemberVO(dto.getId(),hashPw,dto.getName());
            MemberSecVO memberSecVO = new MemberSecVO(dto.getId(),salt);
            memberVo.setMemberSec(memberSecVO);
            memberRepository.save(memberVo);
            memberSecRepository.save(memberSecVO);
        }catch(Exception e){
            throw new JoinException("회원가입 오류");
        }
    }

    //후에 로그인 시도 횟수 로직 추가
    public Token login(MemberLoginDto dto) throws LoginException {
        //유저가 존재하는지 확인, 없으면 exception throw
        MemberVO member = memberRepository.findById(dto.getId()).orElseThrow(()->new LoginException("유저가 존재하지 않습니다."));

        try {
            String salt = member.getMemberSec().getSalt();//해당 유저의 salt값 가져오기
            String hashPw = OpenCrypt.getSHA256(dto.getPassword(), salt);//해당 salt로 입력한 password 해싱

            if(member.getPassword().equals(hashPw)){//일치하면 로그인 성공
                //토큰 발급
                String accessToken = jwtProvider.createToken(member);
                return new Token(accessToken);
            }
            else{
                throw new LoginException("회원 정보가 일치하지 않습니다.");
            }
        } catch(LoginException loginException){
            throw loginException;
        } catch(Exception e){
            throw new LoginException("로그인 오류");
        }
    }
}
