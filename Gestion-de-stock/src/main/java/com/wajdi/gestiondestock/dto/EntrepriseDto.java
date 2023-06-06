package com.wajdi.gestiondestock.dto;


import com.wajdi.gestiondestock.model.CommandeFournisseur;
import com.wajdi.gestiondestock.model.Entreprise;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class EntrepriseDto {

    private Integer id;

    private String nom;

    private  String description;

    private AdresseDto adresse;

    private String codeFiscal;

    private String photo;

    private String email;

    private String numTel;

    private String steWeb;

    private List<UtilisateurDto> utilisateurs;

    public static EntrepriseDto fromEntity(Entreprise entreprise) {
        if(entreprise == null) {
            //to do throug exception
            return  null ;
        }
        //ici c l inverse cad du client dto vers client
        return  EntrepriseDto.builder()
                .nom(entreprise.getNom())
                .description(entreprise.getDescription())
              //  .adresse(entreprise.getAdresse())
                .codeFiscal(entreprise.getCodeFiscal())
                .email(entreprise.getEmail())
                .numTel(entreprise.getNumTel())
                .build();
    }

    public static Entreprise toEntity(EntrepriseDto entrepriseDto) {
        if(entrepriseDto == null) {
            //to do throug exception
            return  null ;
        }
        //ici c l inverse cad du Client dto vers Client
        Entreprise entreprise=new Entreprise();
        entreprise.setNom(entreprise.getNom());
        entreprise.setDescription((entreprise.getDescription()));
        entreprise.setAdresse(entreprise.getAdresse());
        entreprise.setCodeFiscal((entreprise.getCodeFiscal()));
        entreprise.setEmail(entreprise.getEmail());
        entreprise.setNumTel((entreprise.getNumTel()));
        return entreprise;
    }
}
