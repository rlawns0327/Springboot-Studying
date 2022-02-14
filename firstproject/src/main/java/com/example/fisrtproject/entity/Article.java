package com.example.fisrtproject.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity // DB가 해당 객체를 인식 가능!
public class Article {

    @Id // 대표값
    @GeneratedValue // 1, 2, 3 을 DB에 자동생성 해주는 어노테이션
    private Long id;

    @Column // DB 테이블이랑 연결
    private String title;

    @Column // DB 테이블이랑 연결
    private String content;

    public Article(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
