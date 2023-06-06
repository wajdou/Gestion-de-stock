package com.wajdi.gestiondestock.services.impl;

import com.wajdi.gestiondestock.dto.ArticleDto;
import com.wajdi.gestiondestock.execption.EntityNotFoundException;
import com.wajdi.gestiondestock.execption.ErrorCodes;
import com.wajdi.gestiondestock.model.Article;
import com.wajdi.gestiondestock.repositories.ArticleRepository;
import com.wajdi.gestiondestock.services.ArticleService;
import com.wajdi.gestiondestock.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//@Service("articleServiceImpl1")
@Service
@Slf4j

public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository=articleRepository;
    }

    @Override
    public ArticleDto save(ArticleDto dto) {
        List<String> errors= ArticleValidator.validate(dto);
        if(!errors.isEmpty()) {
            log.error("Article is not valid{}", ErrorCodes.ARTICLE_NOT_VALID,errors);
        }

        return ArticleDto.fromEntity(articleRepository.save(ArticleDto.toEntity(dto)));
    }

    @Override
    public ArticleDto findById(Integer id) {
        if(id==null) {
            log.error(("Article ID is null"));
            return null;
        }
        Optional <Article> article=articleRepository.findById(id);

        return Optional.of(ArticleDto.fromEntity(article.get())) .orElseThrow(()->new EntityNotFoundException
                ("Aucun article avec l ID="+id+"n a été trouvé dans la bd" , ErrorCodes.ARTICLE_NOT_FOUND));
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        if(!StringUtils.hasLength(codeArticle)) {
            log.error(("Article CODE is null"));
            return null;
        }
        Optional <Article> article=articleRepository.findArticleByCodeArticle(codeArticle);

        return Optional.of(ArticleDto.fromEntity(article.get())) .orElseThrow(()->new EntityNotFoundException
                ("Aucun article avec le code ="+codeArticle+"n a été trouvé dans la bd" , ErrorCodes.ARTICLE_NOT_FOUND));
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());

    }

    @Override
    public void delete(Integer id) {
        if(id==null) {
            log.error(("Article ID is null"));
            return ;
        }
        articleRepository.deleteById(id);

    }
}
