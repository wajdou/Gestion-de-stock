package com.wajdi.gestiondestock.validator;

import com.wajdi.gestiondestock.dto.FournisseurDto;
import com.wajdi.gestiondestock.dto.VenteDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class VenteValidator {

    public static List<String> validate(VenteDto venteDto) {
        List<String> errors = new ArrayList<>();

        if (venteDto == null ) {
            errors.add("veuillez renseigner le code de la vente");
            errors.add("veuillez renseigner la date du vente");
            errors.add("veuillez renseigner le commentaire du vente");
        }

        if (!StringUtils.hasLength(venteDto.getCode())) {
            errors.add("veuillez renseigner le code de la vente");
        }
        if (venteDto.getDateVente()==null) {
            errors.add("veuillez renseigner la date du vente");
        }
        if (!StringUtils.hasLength(venteDto.getCommantaire())) {
            errors.add("veuillez renseigner le commentaire du vente");
        }
        return errors;


    }
}
