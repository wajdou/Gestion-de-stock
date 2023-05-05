package com.wajdi.gestiondestock.validator;

import com.wajdi.gestiondestock.dto.AdresseDto;
import com.wajdi.gestiondestock.dto.ArticleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AdressValidator {

    public static List<String> validate(AdresseDto adresseDto) {
        List<String> errors = new ArrayList<>();

        if (adresseDto == null ) {
            errors.add("veuillez renseigner l adresse 1");
            errors.add("veuillez renseigner l adresse 2");
            errors.add("veuillez renseigner la ville");
            errors.add("veuillez renseigner le code postale");
            errors.add("veuillez renseigner le pays");

        }

        if (!StringUtils.hasLength(adresseDto.getAdresse1())) {
            errors.add("veuillez renseigner l adresse 1");
        }
        if (!StringUtils.hasLength(adresseDto.getAdresse2())) {
            errors.add("veuillez renseigner l adresse 2");
        }

        if (!StringUtils.hasLength(adresseDto.getVille())) {
            errors.add("veuillez renseigner la ville");
        }
        if (!StringUtils.hasLength(adresseDto.getCodePostale())) {
            errors.add("veuillez renseigner le code postale");
        }
        if (!StringUtils.hasLength(adresseDto.getPays())) {
            errors.add("veuillez renseigner le pays");
        }
        return errors;

    }
}
