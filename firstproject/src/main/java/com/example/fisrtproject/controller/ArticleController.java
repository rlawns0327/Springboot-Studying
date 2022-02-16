package com.example.fisrtproject.controller;

import com.example.fisrtproject.dto.ArticleForm;
import com.example.fisrtproject.entity.Article;
import com.example.fisrtproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j //로깅을 위한 어노테이션
public class ArticleController {

    @Autowired // 스프링부트가 미리 생성해놓은 객체를 연결 그래서 새로 new를 이용해 생성할 필요 없음
    private ArticleRepository articleRepository;

    @GetMapping("articles/new")
    public String newArticleForm() {
        return "articles/new";  // templates를 찾아가기때문에 그 안에 있으면 경로또한 명시
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
        log.info(form.toString());

        // 1. Dto를 변환 Entity로 -> DB는 Entity로 받기 때문
        Article article = form.toEntity();
        log.info(article.toString());

        // 2. Repository에게 Entity를 DB안에 저장하게 함
        Article saved = articleRepository.save(article);
        log.info(saved.toString());

        return "redirect:/articles/"+ saved.getId();
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model){
        log.info("id = "+ id);

        //1. id로 데이터를 가져옴
        //Optional<Article> articleEntity = articleRepository.findById(id);
        Article articleEntity = articleRepository.findById(id).orElse(null); //값이 없으면 null을 반환

        // 2. 가져온 데이터를 모델에 등록
        model.addAttribute("article", articleEntity);

        // 3. 보여줄 페이지 설정
        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model) {
        // 모든 article을 가져온다
        List<Article> articleEntityList = articleRepository.findAll();
        //ArrayList<Article> articleEntityList = (List<Article>)articleRepository.findAll();
        //List<Article> articleEntityList = (List<Article>)articleRepository.findAll();
        // Iterable<Article> articleEntityList = articleRepository.findAll();

        // 가져온 article 묶음을 뷰로 전달
        model.addAttribute("articleList",articleEntityList);
        // 뷰페이지를 설정
        return "articles/index";

    }

    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        // 수정할 데이터를 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);

        //모델의 데이터 등록
        model.addAttribute("article", articleEntity);
        log.info(articleEntity.toString());
        // 뷰페이지 설정
        return "articles/edit";
    }
}
