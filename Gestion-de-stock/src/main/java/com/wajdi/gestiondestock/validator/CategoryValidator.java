package com.wajdi.gestiondestock.validator;

import com.wajdi.gestiondestock.dto.ArticleDto;
import com.wajdi.gestiondestock.dto.CategorieDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {

    public static  List<String> validate(CategorieDto categorieDto) {
        List<String> errors =new ArrayList<>();

        if (categorieDto == null ) {
            errors.add("veuillez renseigner la categorie");
            errors.add("veuillez renseigner la designation");

        }
        if(!StringUtils.hasLength(categorieDto.getCode())) {
            errors.add("veuillez renseigner le code de la categorie");
        }
        if(!StringUtils.hasLength(categorieDto.getDesignation())) {
            errors.add("veuillez renseigner le code de la designation");
        }
        return errors;

}
}
