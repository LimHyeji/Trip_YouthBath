package com.ssafy.enjoytrip.board.model.dto;

import java.util.List;

public class BoardListDto {
    private boolean next;
    private boolean prev;
    private List<BoardDto> articles;

    public BoardListDto(boolean next, boolean prev, List<BoardDto> articles) {
        setNext(next);
        setPrev(prev);
        setArticles(articles);
    }

    public BoardListDto() {
    }

    public boolean isNext() {
        return next;
    }

    public void setNext(boolean next) {
        this.next = next;
    }

    public boolean isPrev() {
        return prev;
    }

    public void setPrev(boolean prev) {
        this.prev = prev;
    }

    public List<BoardDto> getArticles() {
        return articles;
    }

    public void setArticles(List<BoardDto> articles) {
        this.articles = articles;
    }
}
