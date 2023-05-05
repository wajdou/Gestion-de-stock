package com.wajdi.gestiondestock.validator;

import com.wajdi.gestiondestock.dto.CategorieDto;
import com.wajdi.gestiondestock.dto.MvtStkDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class MvtStkValidator {
    public static List<String> validate(MvtStkDto mvtStkDto) {
        List<String> errors =new ArrayList<>();

        if (mvtStkDto == null ) {
            errors.add("veuillez renseigner la quantité");
            errors.add("veuillez renseigner l article");
            errors.add("veuillez renseigner la date de mvt");

        }
        if(mvtStkDto.getQuantite()==null) {
            errors.add("veuillez renseigner le code de la quantité");
        }
        if(!StringUtils.hasLength(mvtStkDto.getArticle().getCodeArticle())) {
            errors.add("veuillez renseigner le code de la designation");
        }
        if(mvtStkDto.getDateMvt()==null) {
            errors.add("veuillez renseigner le code de la date Mvt");
        }
        return errors;

    }
}
