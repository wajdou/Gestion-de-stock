package com.wajdi.gestiondestock.controller.api;

import com.wajdi.gestiondestock.dto.ArticleDto;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.awt.*;
import java.util.List;

import static  com.wajdi.gestiondestock.utils.Constants.APP_ROOT;
public interface ArticleApi {
    @PostMapping(value =APP_ROOT+"/articles/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto save (ArticleDto dto);

    @GetMapping(value = APP_ROOT+"/articles/{idArticle}",produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findById (@PathVariable("idArticle") Integer id);

    @GetMapping(value = APP_ROOT+"/articles/{codeArticle}",produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findByCodeArticle (@PathVariable("codeArticle") String codeArticle);

    @GetMapping(value = APP_ROOT+"/articles/all",produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDto> findAll();

    @DeleteMapping(value = APP_ROOT+"/articles/delete/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete (@PathVariable("idArticle") Integer id);
}
