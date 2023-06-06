package com.wajdi.gestiondestock.services;

import com.wajdi.gestiondestock.dto.ArticleDto;


import com.wajdi.gestiondestock.model.Roles;


import java.util.List;

public interface ArticleService {

    ArticleDto save (ArticleDto dto);
    ArticleDto findById (Integer id);

    ArticleDto findByCodeArticle (String codeArticle);
    List<ArticleDto> findAll();
    void delete (Integer id);
}
