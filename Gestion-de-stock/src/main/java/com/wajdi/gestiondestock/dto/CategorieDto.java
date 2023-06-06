package com.wajdi.gestiondestock.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wajdi.gestiondestock.model.Categorie;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class CategorieDto {

    private Integer id;

    private String code;

    private String designation;

    @JsonIgnore
    private List<ArticleDto> articles;

    public static CategorieDto fromEntity(Categorie categorie) {
        if(categorie == null) {
            //to do throug exception
            return  null ;
        }
 //ici c l inverse cad du categorie dto vers categorie
        return  CategorieDto.builder()
            .id(categorie.getId())
            .code(categorie.getCode())
            .designation(categorie.getDesignation())
            .build();
    }

    public static Categorie toEntity(CategorieDto categorieDto) {
        if(categorieDto == null) {
            //to do throug exception
            return  null ;
        }
        //ici c l inverse cad du categorie dto vers categorie
       Categorie categorie=new Categorie();
        categorie.setId(categorieDto.getId());
        categorie.setCode((categorie.getCode()));
        categorie.setDesignation(categorieDto.getDesignation());
        return categorie;
    }
}
