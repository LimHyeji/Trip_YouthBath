package com.ssafy.enjoytrip.board.model.service;

import com.ssafy.enjoytrip.board.model.dto.BoardDeleteDto;
import com.ssafy.enjoytrip.board.model.dto.BoardDto;
import com.ssafy.enjoytrip.board.model.dto.BoardListDto;
import com.ssafy.enjoytrip.board.model.util.DeleteException;
import com.ssafy.enjoytrip.board.model.util.ModifyException;
import com.ssafy.enjoytrip.board.model.util.RegistException;
import com.ssafy.enjoytrip.member.util.InfoCheckException;

public interface BoardService {
    BoardDto regist(String token,BoardDto dto) throws RegistException;

    BoardListDto getList(int pageNo);

    BoardDto modify(String token,BoardDto dto) throws ModifyException;

    void delete(String token, BoardDeleteDto dto) throws DeleteException;

    BoardDto detail(Long articleNo) throws InfoCheckException;
}
