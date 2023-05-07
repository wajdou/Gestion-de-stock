package com.wajdi.gestiondestock.repositories;

import com.wajdi.gestiondestock.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends JpaRepository <Integer, Article>{
/*
@Query(value = "select a from Article  where  codeArticle=:code and designation=:designation",nativeQuery = false)
List<Article> findByCustomerQuery(@Param("code") String c,@Param("designation") String d);


    @Query(value = "select a from Article  where  codeArticle=:code and designation=:designation",nativeQuery = true)
    List<Article> findByCustomerNativeQuery(@Param("code") String c,@Param("designation") String d);

    List<Article>findByCodeArticleIgnoreCaseAndDesignationIgnoreCase(String codeArticle,String designation);

 */
}
