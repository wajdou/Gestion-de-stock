package com.wajdi.gestiondestock.validator;

import com.wajdi.gestiondestock.dto.ArticleDto;
import com.wajdi.gestiondestock.dto.ClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {

    public static List<String> validate(ClientDto clientDto) {
        List<String> errors = new ArrayList<>();

        if (clientDto == null ) {
            errors.add("veuillez renseigner le nom");
            errors.add("veuillez renseigner le prenom");
            errors.add("veuillez renseigner l email");
            errors.add("veuillez renseigner le  numero de telephone");

        }

        if (!StringUtils.hasLength(clientDto.getNom())) {
            errors.add("veuillez renseigner le code de l article");
        }
        if (!StringUtils.hasLength(clientDto.getPrenom())) {
            errors.add("veuillez renseigner le prenom");
        }
        if(clientDto.getMail()==null){
            errors.add("veuillez renseigner l email");
        }
        if (clientDto.getNumTel()==null) {
            errors.add("veuillez renseigner le  numero de telephone");
        }
        return errors;


        }


}
