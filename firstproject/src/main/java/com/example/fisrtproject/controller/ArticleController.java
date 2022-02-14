package com.example.fisrtproject.controller;

import com.example.fisrtproject.dto.ArticleForm;
import com.example.fisrtproject.entity.Article;
import com.example.fisrtproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    @Autowired // 스프링부트가 미리 생성해놓은 객체를 연결 그래서 새로 new를 이용해 생성할 필요 없음
    private ArticleRepository articleRepository;

    @GetMapping("articles/new")
    public String newArticleForm() {
        return "articles/new";  // templates를 찾아가기때문에 그 안에 있으면 경로또한 명시
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
        System.out.println(form.toString());

        // 1. Dto를 변환 Entity로 -> DB는 Entity로 받기 때문
        Article article = form.toEntity();
        System.out.println(article.toString());

        // 2. Repository에게 Entity를 DB안에 저장하게 함
        Article saved = articleRepository.save(article);
        System.out.printf(saved.toString());

        return "";
    }

}
