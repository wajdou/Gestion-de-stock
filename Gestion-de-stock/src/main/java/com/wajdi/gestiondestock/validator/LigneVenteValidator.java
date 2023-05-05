package com.wajdi.gestiondestock.validator;

import com.wajdi.gestiondestock.dto.ClientDto;
import com.wajdi.gestiondestock.dto.LigneVenteDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LigneVenteValidator {

        public static List<String> validate(LigneVenteDto ligneVenteDto) {
        List<String> errors = new ArrayList<>();

        if (ligneVenteDto == null ) {
            errors.add("veuillez renseigner la quantité de la ligne Vente");
            errors.add("veuillez renseigner le prix unitaire de la ligne Vente");

        }

        if (ligneVenteDto.getQuantite()==null) {
            errors.add("veuillez renseigner la quantite de la ligne vente");
        }
        if (ligneVenteDto.getPrixUnitaire()==null) {
            errors.add("veuillez renseigner le prix unitaire de la ligne vente");
        }

        return errors;


    }
}
