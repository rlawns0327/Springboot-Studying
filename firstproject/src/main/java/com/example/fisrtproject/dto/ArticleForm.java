package com.example.fisrtproject.dto;

import com.example.fisrtproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor //14-16줄까지 생성자 자동생성
@ToString // 22~27줄까지 ToString 자동생성
public class ArticleForm {

    private String title;
    private String content;

    /*
    public ArticleForm(String title, String content) {
        this.title = title;
        this.content = content;
    }
    */
    /*
    @Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
    */
    public Article toEntity() {
        return new Article(null,title,content);

    }
}
