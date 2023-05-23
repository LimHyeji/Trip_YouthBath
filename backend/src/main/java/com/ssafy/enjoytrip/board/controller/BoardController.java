package com.ssafy.enjoytrip.board.controller;

import com.ssafy.enjoytrip.board.model.dto.BoardDeleteDto;
import com.ssafy.enjoytrip.board.model.dto.BoardDto;
import com.ssafy.enjoytrip.board.model.dto.BoardListDto;
import com.ssafy.enjoytrip.board.model.service.BoardService;
import com.ssafy.enjoytrip.board.model.util.DeleteException;
import com.ssafy.enjoytrip.board.model.util.ModifyException;
import com.ssafy.enjoytrip.board.model.util.RegistException;
import com.ssafy.enjoytrip.member.util.InfoCheckException;
import com.ssafy.enjoytrip.util.ApiUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

import static com.ssafy.enjoytrip.util.ApiUtils.*;

@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping
    public ResponseEntity<ApiResult<BoardDto>> regist(
            @RequestHeader("Authorization") String authorization,
            @RequestBody BoardDto dto
    ) throws RegistException {
        String token = authorization.split(" ")[1];
        return success(boardService.regist(token,dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ApiResult<BoardListDto>> findAllWithPage(
            @RequestParam(required = false,defaultValue = "0",name="pageno") int pageno){
        System.out.println("pageno = " + pageno);
        return success(boardService.getList(pageno),HttpStatus.OK);
    }

    @PostMapping("/modify")
    public ResponseEntity<ApiResult<BoardDto>> modify(
            @RequestHeader("Authorization") String authorization,
            @RequestBody BoardDto dto
    ) throws ModifyException {
        String token = authorization.split(" ")[1];
        return success(boardService.modify(token,dto),HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<ApiResult<String>> delete(
            @RequestHeader("Authorization") String authorization,
            @RequestBody BoardDeleteDto dto
            ) throws DeleteException {
        String token = authorization.split(" ")[1];
        boardService.delete(token,dto);
        return success("성공했습니다.",HttpStatus.OK);
    }

    @GetMapping("/{articleNo}")
    public ResponseEntity<ApiResult<BoardDto>> detail(
            @PathVariable(required=true,name="articleNo") Long articleNo
    ) throws InfoCheckException {
        return success(boardService.detail(articleNo),HttpStatus.OK);
    }
}
