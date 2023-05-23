package com.ssafy.enjoytrip.board.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ssafy.enjoytrip.member.model.vo.MemberVO;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "board")
@EntityListeners(AuditingEntityListener.class)
public class BoardVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="articleno")
    private Long articleNo;

    @Column(name="title")
    private String title;

    @Column(name="content")
    private String content;

    @Column(name="hit")
    private int hit;

    @Column(name="regTime",updatable = false)
    @CreatedDate
    private LocalDateTime regTime;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "writer")
    private MemberVO writer;

    public BoardVO(Long articleNo, String title, String content, int hit, MemberVO writer) {
        setArticleNo(articleNo);
        setTitle(title);
        setContent(content);
        setHit(hit);
        setWriter(writer);
    }

    public BoardVO() {
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

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public MemberVO getWriter() {
        return writer;
    }

    public void setWriter(MemberVO writer) {
        this.writer = writer;
    }

    public LocalDateTime getRegTime() {
        return regTime;
    }

    public void setRegTime(LocalDateTime regTime) {
        this.regTime = regTime;
    }

    public void updateHit(){
        this.hit++;
    }

    @Override
    public String toString() {
        return "BoardVO{" +
                "articleNo=" + articleNo +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", hit=" + hit +
                ", regTime=" + regTime +
                ", writer=" + writer +
                '}';
    }
}
