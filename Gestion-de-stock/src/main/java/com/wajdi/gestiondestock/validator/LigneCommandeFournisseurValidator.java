package com.wajdi.gestiondestock.validator;

import com.wajdi.gestiondestock.dto.LigneCommandeClientDto;
import com.wajdi.gestiondestock.dto.LigneCommandeFournisseurDto;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeFournisseurValidator {

    public static List<String> validate(LigneCommandeFournisseurDto ligneCommandeFournisseurDto) {
        List<String> errors = new ArrayList<>();

        if (ligneCommandeFournisseurDto == null ) {
            errors.add("veuillez renseigner l article du fournisseur");
            errors.add("veuillez renseigner la commande fournisseur ");
            errors.add("veuillez renseigner la quantité de la ligne commandeFournisseur");
            errors.add("veuillez renseigner le  prix unitairede de la ligne commandeFournisseur");

        }

        if (ligneCommandeFournisseurDto.getArticle()==null) {
            errors.add("veuillez renseigner l article du fournisseur");
        }
        if(ligneCommandeFournisseurDto.getCommandeFournisseur()==null){
            errors.add("veuillez renseigner la commande fournisseur");
        }
        if (ligneCommandeFournisseurDto.getQuantite()==null) {
            errors.add("veuillez renseigner la quantité de la ligne commandeFournisseur");
        }
        if (ligneCommandeFournisseurDto.getPrixUnitaire()==null) {
            errors.add("veuillez renseigner le  prix unitairede de la ligne commandeFournisseur");
        }
        return errors;


    }
}
