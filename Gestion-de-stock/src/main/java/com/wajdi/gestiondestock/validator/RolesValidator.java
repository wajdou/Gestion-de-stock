package com.wajdi.gestiondestock.validator;

import com.wajdi.gestiondestock.dto.FournisseurDto;
import com.wajdi.gestiondestock.dto.RolesDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RolesValidator {

    public static List<String> validate(RolesDto rolesDto) {
        List<String> errors = new ArrayList<>();

        if (rolesDto == null ) {
            errors.add("veuillez renseigner le nom du role");
            errors.add("veuillez renseigner le user role ");

        }

        if (!StringUtils.hasLength(rolesDto.getRoleName())) {
            errors.add("veuillez renseigner le nom du fournisseur");
        }
        if (rolesDto.getUtilisateur()==null) {
            errors.add("veuillez renseigner le prenom du fournisseur");
        }
        return errors;


    }
}
