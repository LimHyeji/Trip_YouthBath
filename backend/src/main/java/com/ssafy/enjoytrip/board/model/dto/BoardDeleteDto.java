package com.ssafy.enjoytrip.board.model.dto;

public class BoardDeleteDto {
    private Long articleno;

    public BoardDeleteDto() {
    }

    public BoardDeleteDto(Long articleno) {
        setArticleno(articleno);
    }

    public Long getArticleno() {
        return articleno;
    }

    public void setArticleno(Long articleno) {
        this.articleno = articleno;
    }
}
