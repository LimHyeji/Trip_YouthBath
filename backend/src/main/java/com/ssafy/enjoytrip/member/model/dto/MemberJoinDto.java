package com.ssafy.enjoytrip.member.model.dto;

import com.ssafy.enjoytrip.member.util.JoinException;
import com.ssafy.enjoytrip.util.StringUtils;
import jdk.internal.joptsimple.util.RegexMatcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class MemberJoinDto {
    private String id;
    private String password;
    private String passwordCheck;
    private String name;

    public MemberJoinDto(String id, String password, String passwordCheck, String name) throws JoinException {
        setId(id);
        setPassword(password);
        setPasswordCheck(passwordCheck);
        setName(name);
    }


    public String getId() {
        return id;
    }

    public void setId(String id) throws JoinException {
        String pattern = "[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}";//이메일 형식을 검증하는 표현식

        /*
        * 1. blank가 아니여야함
        * 2. 길이가 5 이상이여야함
        * 3. 이메일 형식이여야함
        * 4. 아니면 JoinException을 throw
        * */
        System.out.println("hello world! input = "+id);
        if(!StringUtils.isBlank(id) && id.length() >= 5 && Pattern.matches(pattern,id)){
            System.out.println("check");
            this.id = id;
        }
        else {
            System.out.println("uncheck");
            System.out.println(Pattern.matches(pattern,id));
            throw new JoinException("5자 이상의 이메일을 입력해주세요");
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws JoinException {
          /*
            1. 대문자/소문자/숫자/기호 각각 최소 1개 이상 포함
            2. 10자 이상의 길이
            3. 연속된 숫자 x
            4. 아이디와 3자리 이상 중복 x -> 이건 service레이어에서 처리
        */
//        String pattern = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\\\d)(?=.*[!@#$%^&*()-=_+`~\\\\[\\\\]\\\\\\\\{}|;':\\\",./<>?])(?!.*(.)\\\\1\\\\1\\\\1)(?!.*(1234|1111))(?=.{10,})[A-Za-z\\\\d!@#$%^&*()-=_+`~\\\\[\\\\]\\\\\\\\{}|;':\\\",./<>?]+$";
//        if(StringUtils.isBlank(password) || !Pattern.matches(pattern,password)){
        if (StringUtils.isBlank(password)) {
            throw new JoinException("비밀번호 조건에 맞지 않습니다.");
        }

        int sCount = 0;//소문자 개수
        int bCount = 0;//대문자 개수
        int nCount = 0;//숫자 개수
        int specialCount = 0;//특수문자 개수

        char[] carray = password.toCharArray();
        List<Character> specialCharacters = new ArrayList<>(Arrays.asList(new Character[]{'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '=', '_', '+', '`', '~',
                '[', ']', '\\', '{', '}', '|', ';', ':', '\'', '"', ',', '.', '/', '<', '>', '?'}));
        for (int i = 0; i < carray.length; i++) {
            char c = carray[i];
            if (c >= 'a' && c <= 'z') sCount++;
            else if (c >= 'A' && c <= 'Z') bCount++;
            else if (c >= '0' && c <= '9') nCount++;
            else if (specialCharacters.contains(c)) specialCount++;
        }

        if (sCount != 0 && bCount != 0 && nCount != 0 && specialCount != 0 && sCount+bCount+nCount+specialCount >= 10){
            this.password = password;
        }
        else{
            throw new JoinException("비밀번호 조건에 맞지 않습니다.");
        }

    }

    public String getPasswordCheck() {
        return passwordCheck;
    }

    public void setPasswordCheck(String passwordCheck) throws JoinException {
        if(StringUtils.isBlank(passwordCheck)){
            throw new JoinException("비밀번호 확인란을 작성해주세요");
        }
        this.passwordCheck = passwordCheck;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws JoinException {
        if(StringUtils.isBlank(name)){
            throw new JoinException("이름을 입력해주세요");
        }
        this.name = name;
    }
}
