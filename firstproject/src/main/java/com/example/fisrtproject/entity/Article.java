package com.example.fisrtproject.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity // DB가 해당 객체를 인식 가능!
@AllArgsConstructor //모든 필드에 있는 값들에 대해 생성자 생성
@NoArgsConstructor // 디폴드 생성자
@Getter
@ToString
public class Article {

    @Id // 대표값
    @GeneratedValue // 1, 2, 3 을 DB에 자동생성 해주는 어노테이션
    private Long id;

    @Column // DB 테이블이랑 연결
    private String title;

    @Column // DB 테이블이랑 연결
    private String content;

}
