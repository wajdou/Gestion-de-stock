package com.wajdi.gestiondestock.repositories;

import com.wajdi.gestiondestock.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository <Article, Integer>{

/*
@Query(value = "select a from Article  where  codeArticle=:code and designation=:designation",nativeQuery = false)

    List<Article>findByCodeArticleIgnoreCaseAndDesignationIgnoreCase(String codeArticle,String designation);

 */

    Optional< Article>  findArticleByCodeArticle (String codeArticle);

}
