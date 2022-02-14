package com.example.fisrtproject.repository;

import com.example.fisrtproject.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article,Long> {

}
