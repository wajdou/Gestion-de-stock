package com.wajdi.gestiondestock.validator;

import com.wajdi.gestiondestock.dto.ArticleDto;
import com.wajdi.gestiondestock.dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {

    public static List<String> validate(ArticleDto articleDto) {
        List<String> errors = new ArrayList<>();

        if (articleDto == null ) {
            errors.add("veuillez renseigner le code d article");
            errors.add("veuillez renseigner la designation de l artocle");
            errors.add("veuillez renseigner le prix unitaire HT de l article");
            errors.add("veuillez renseigner le taux TVAS de l article");
            errors.add("veuillez renseigner le prix unitaire TTC de l article");
            errors.add("veuillez selectionnez une categorie");



        }

        if (!StringUtils.hasLength(articleDto.getCodeArticle())) {
            errors.add("veuillez renseigner le code de l article");
        }
        if (!StringUtils.hasLength(articleDto.getDesignation())) {
            errors.add("veuillez renseigner la designation");
        }
        if(articleDto.getPrixUnitaireHT()==null){
            errors.add("veuillez renseigner le prix unitaire HT");
        }
        if (articleDto.getTauxTva()==null) {
            errors.add("veuillez renseigner le taux TVA");
        }
        if ((articleDto.getPrixUnitaireTtc() == null)) {
            errors.add("veuillez renseigner le prix unitaire TTC");
        }
            if (articleDto.getDesignation()==null) {
                errors.add("veuillez selectionney une categorie");

            }
        return errors;

        }

    }

