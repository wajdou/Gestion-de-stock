package com.wajdi.gestiondestock.controller;

import com.wajdi.gestiondestock.controller.api.ArticleApi;
import com.wajdi.gestiondestock.dto.ArticleDto;
import com.wajdi.gestiondestock.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController implements ArticleApi {
private ArticleService articleService;

@Autowired
    public ArticleController(ArticleService articleService) {
    this.articleService=articleService;
    }

    @Override
    public ArticleDto save(ArticleDto dto) {
        return articleService.save(dto);
    }

    @Override
    public ArticleDto findById(Integer id) {
        return articleService.findById(id);
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        return articleService.findByCodeArticle(codeArticle);
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleService.findAll();
    }

    @Override
    public void delete(Integer id) {
    articleService.delete(id);

    }
    // @Autowired
    //pour savoir qu elle service doit je injecter,tu crée artivleServiceImpl1
    //@Qualifier("articleServiceImpl1")
  //  private ArticleService articleService;
}
