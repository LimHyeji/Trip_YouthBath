package com.ssafy.enjoytrip.board.model.service;

import com.ssafy.enjoytrip.board.model.dto.BoardDeleteDto;
import com.ssafy.enjoytrip.board.model.dto.BoardDto;
import com.ssafy.enjoytrip.board.model.dto.BoardListDto;
import com.ssafy.enjoytrip.board.model.repository.BoardRepository;
import com.ssafy.enjoytrip.board.model.util.DeleteException;
import com.ssafy.enjoytrip.board.model.util.ModifyException;
import com.ssafy.enjoytrip.board.model.util.RegistException;
import com.ssafy.enjoytrip.board.model.vo.BoardVO;
import com.ssafy.enjoytrip.member.model.repository.MemberRepository;
import com.ssafy.enjoytrip.member.model.vo.MemberVO;
import com.ssafy.enjoytrip.member.util.InfoCheckException;
import com.ssafy.enjoytrip.util.jwt.JWTException;
import com.ssafy.enjoytrip.util.jwt.JWTProvider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardServiceImpl implements BoardService{
    private final JWTProvider jwtProvider;
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    public BoardServiceImpl(JWTProvider jwtProvider, BoardRepository boardRepository, MemberRepository memberRepository) {
        this.jwtProvider = jwtProvider;
        this.boardRepository = boardRepository;
        this.memberRepository = memberRepository;
    }

    private BoardDto convertToDto(BoardVO vo){
        BoardDto dto = new BoardDto();
        dto.setArticleNo(vo.getArticleNo());
        dto.setTitle(vo.getTitle());
        dto.setContent(vo.getContent());
        dto.setWriter(vo.getWriter().getId());
        dto.setHit(vo.getHit());
        dto.setRegTime(vo.getRegTime());
        return dto;
    }

    @Override
    @Transactional
    public BoardDto regist(String token, BoardDto dto) throws RegistException {
        try {
            //jwt parse
            MemberVO tokenInfo = jwtProvider.parseInfo(token);

            //jwt에 들어있는 id값으로 멤버를 조회
            MemberVO memberVO = memberRepository.findById(tokenInfo.getId()).orElseThrow(() -> new InfoCheckException("사용자가 존재하지 않습니다."));

            BoardVO board = new BoardVO();
            board.setTitle(dto.getTitle());
            board.setContent(dto.getContent());
            board.setWriter(memberVO);


            BoardVO saved = boardRepository.save(board);
            BoardDto result = convertToDto(saved);
            return result;
        }catch(JWTException jwtException){
            throw new RegistException("다시 인증해주세요");
        } catch (InfoCheckException e) {
            throw new RegistException(e.getMessage());
        }
    }

    @Override
    public BoardListDto getList(int pageNo) {
        final int DEFAULT_SIZE = 10;
        Pageable pageable = PageRequest.of(pageNo,DEFAULT_SIZE, Sort.by("regTime").descending());

        Page<BoardVO> all = boardRepository.findAll(pageable);

        List<BoardDto> articles = all.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        int pages = all.getTotalPages();
        boolean prev = pageNo != 0;
        boolean next = pageNo != pages-1;

        BoardListDto result = new BoardListDto(next,prev,articles);
        return result;
    }

    @Override
    public BoardDto modify(String token, BoardDto dto) throws ModifyException {
        try {
            //jwt에서 정보 파싱
            MemberVO info = jwtProvider.parseInfo(token);

            //파싱된 정보로 데이터베이스에서 유저정보를 가져옴
            MemberVO memberVO = memberRepository.findById(info.getId()).orElseThrow(() -> new InfoCheckException("유저가 존재하지 않습니다."));

            //입력받은 board의 articleNo에 해당하는 board를 가져옴
            BoardVO boardVO = boardRepository.findById(dto.getArticleNo()).orElseThrow(() -> new InfoCheckException("게시글이 존재하지 않습니다."));

            if(!boardVO.getWriter().getId().equals(memberVO.getId())) throw new InfoCheckException("권한이 존재하지 않습니다.");

            boardVO.setTitle(dto.getTitle());
            boardVO.setContent(dto.getContent());

            BoardVO saved = boardRepository.save(boardVO);

            return convertToDto(saved);
        }catch(JWTException jwtException){
            throw new ModifyException("다시 인증해주세요");
        }catch(InfoCheckException infoCheckException){
            throw new ModifyException(infoCheckException.getMessage());
        }

    }

    @Override
    public void delete(String token, BoardDeleteDto dto) throws DeleteException {
        try{
            //jwt에서 정보 파싱
            MemberVO info = jwtProvider.parseInfo(token);

            //파싱된 정보로 데이터베이스에서 유저정보를 가져옴
            MemberVO memberVO = memberRepository.findById(info.getId()).orElseThrow(() -> new InfoCheckException("유저가 존재하지 않습니다."));

            //입력받은 board의 articleNo에 해당하는 board를 가져옴
            BoardVO boardVO = boardRepository.findById(dto.getArticleno()).orElseThrow(() -> new InfoCheckException("게시글이 존재하지 않습니다."));

            if(!boardVO.getWriter().getId().equals(memberVO.getId())) throw new InfoCheckException("권한이 존재하지 않습니다.");
            boardRepository.deleteById(boardVO.getArticleNo());
        } catch (JWTException e) {
            throw new DeleteException("다시 인증해주세요");
        } catch (InfoCheckException e) {
            throw new DeleteException(e.getMessage());
        }
    }

    @Override
    public BoardDto detail(Long articleNo) throws InfoCheckException {
        return convertToDto(boardRepository.findById(articleNo).orElseThrow(()->new InfoCheckException("해당하는 게시물이 없어요")));
    }
}
