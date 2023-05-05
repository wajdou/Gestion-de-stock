package com.wajdi.gestiondestock.validator;

import com.wajdi.gestiondestock.dto.ClientDto;
import com.wajdi.gestiondestock.dto.FournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FournisseurValidator {

    public static List<String> validate(FournisseurDto fournisseurDto) {
        List<String> errors = new ArrayList<>();

        if (fournisseurDto == null ) {
            errors.add("veuillez renseigner le nom du fournisseur");
            errors.add("veuillez renseigner le prenom du fournisseur");
            errors.add("veuillez renseigner l email du fournisseur");
            errors.add("veuillez renseigner le  numero de telephone du fournisseur");

        }

        if (!StringUtils.hasLength(fournisseurDto.getNom())) {
            errors.add("veuillez renseigner le nom du fournisseur");
        }
        if (!StringUtils.hasLength(fournisseurDto.getPrenom())) {
            errors.add("veuillez renseigner le prenom du fournisseur");
        }
        if(fournisseurDto.getMail()==null){
            errors.add("veuillez renseigner l email du fournisseur");
        }
        if (fournisseurDto.getNumTel()==null) {
            errors.add("veuillez renseigner le  numero de telephone du fournisseur");
        }
        return errors;


    }

}
