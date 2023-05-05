package com.wajdi.gestiondestock.validator;

import com.wajdi.gestiondestock.dto.EntrepriseDto;
import com.wajdi.gestiondestock.dto.FournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EntrepriseValidator {

    public static List<String> validate(EntrepriseDto entrepriseDto) {
        List<String> errors = new ArrayList<>();

        if (entrepriseDto == null ) {
            errors.add("veuillez renseigner le nom de l entreprise");
            errors.add("veuillez renseigner l adresse de l entreprise");
            errors.add("veuillez renseigner l email de l entreprise");
            errors.add("veuillez renseigner le  numero de telephone de l entreprise");

        }

        if (!StringUtils.hasLength(entrepriseDto.getNom())) {
            errors.add("veuillez renseigner le nom de l entreprise ");
        }
        if (entrepriseDto.getAdresse()==null) {
            errors.add("veuillez renseigner l adresse de l entreprise");
        }
        if(entrepriseDto.getEmail()==null){
            errors.add("veuillez renseigner l email de l entreprise");
        }
        if (entrepriseDto.getNumTel()==null) {
            errors.add("veuillez renseigner le  numero de telephone de l entreprise");
        }
        return errors;


    }
}
