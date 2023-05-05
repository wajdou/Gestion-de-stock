package com.wajdi.gestiondestock.validator;

import com.wajdi.gestiondestock.dto.EntrepriseDto;
import com.wajdi.gestiondestock.dto.LigneCommandeClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeClientValidator {

    public static List<String> validate(LigneCommandeClientDto ligneCommandeClientDto) {
        List<String> errors = new ArrayList<>();

        if (ligneCommandeClientDto == null ) {
            errors.add("veuillez renseigner l article du client");
            errors.add("veuillez renseigner la commande client ");
            errors.add("veuillez renseigner la quantité de la ligne commandeClient");
            errors.add("veuillez renseigner le  prix unitairede de la ligne commandeClient");

        }

        if (ligneCommandeClientDto.getArticle()==null) {
            errors.add("veuillez renseigner l article du client");
        }
        if(ligneCommandeClientDto.getCommandeClient()==null){
            errors.add("veuillez renseigner la commande client");
        }
        if (ligneCommandeClientDto.getQuantite()==null) {
            errors.add("veuillez renseigner la quantité de la ligne commandeClient");
        }
        if (ligneCommandeClientDto.getPrixUnitaire()==null) {
            errors.add("veuillez renseigner le  prix unitairede de la ligne commandeClient");
        }
        return errors;


    }
}
