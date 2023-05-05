package com.wajdi.gestiondestock.dto;


import com.wajdi.gestiondestock.model.Article;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class ArticleDto {

    private Integer id;

    private String codeArticle;

    private String designation;

    private BigDecimal prixUnitaireHT;

    private BigDecimal tauxTva;

    private BigDecimal prixUnitaireTtc;

    private String photo;

    private CategorieDto categorie;

    public static ArticleDto fromEntity(Article article) {
        if(article == null) {
            //to do throug exception
            return  null ;
        }
        //ici c l inverse cad du article dto vers article
        return  ArticleDto.builder()
                .designation(article.getDesignation())
                .photo(article.getPhoto())
                .tauxTva(article.getTauxTva())
                .prixUnitaireHT(article.getPrixUnitaireHT())
                .prixUnitaireTtc(article.getPrixUnitaireTtc())
                .build();
    }

    public static Article toEntity(ArticleDto articleDto) {
        if(articleDto == null) {
            //to do throug exception
            return  null ;
        }
        //ici c l inverse cad du categorie dto vers categorie
        Article article=new Article();
        article.setDesignation(articleDto.getDesignation());
        article.setPhoto((articleDto.getPhoto()));
        article.setTauxTva(articleDto.getTauxTva());
        article.setPrixUnitaireHT(articleDto.getPrixUnitaireHT());
        article.setPrixUnitaireTtc(articleDto.getPrixUnitaireTtc());
        return article;
    }


}
