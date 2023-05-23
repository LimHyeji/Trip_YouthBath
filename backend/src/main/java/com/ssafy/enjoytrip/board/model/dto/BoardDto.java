package com.ssafy.enjoytrip.board.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class BoardDto {
    private Long articleNo;
    private String title;
    private String content;
    private String writer;
    private int hit;
    @JsonFormat(shape=JsonFormat.Shape.STRING
            ,pattern="yyyy-MM-dd HH:mm",timezone = "Asia/Seoul")
    private LocalDateTime regTime;


    public BoardDto() {
    }

    public BoardDto(Long articleNo, String title, String content, String writer, int hit, LocalDateTime regTime) {
        setArticleNo(articleNo);
        setTitle(title);
        setContent(content);
        setWriter(writer);
        setHit(hit);
        setRegTime(regTime);
    }

    public Long getArticleNo() {
        return articleNo;
    }

    public void setArticleNo(Long articleNo) {
        this.articleNo = articleNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public LocalDateTime getRegTime() {
        return regTime;
    }

    public void setRegTime(LocalDateTime regTime) {
        this.regTime = regTime;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "articleNo=" + articleNo +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", hit=" + hit +
                ", regTime=" + regTime +
                '}';
    }
}
