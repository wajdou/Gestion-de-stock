package com.wajdi.gestiondestock.dto;

import com.wajdi.gestiondestock.model.Entreprise;
import com.wajdi.gestiondestock.model.Fournisseur;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class FournisseurDto {

    private Integer id;

    private String nom;

    private String prenom;

    private AdresseDto adresse;

    private String photo;

    private String mail;

    private String numTel;

    private List<CommandeFournisseurDto> commandeFournisseurs;

    public static FournisseurDto fromEntity(FournisseurDto fournisseurDto) {
        if(fournisseurDto == null) {
            //to do throug exception
            return  null ;
        }
        //ici c l inverse cad du client dto vers client
        return  FournisseurDto.builder()
                .nom(fournisseurDto.getNom())
                .prenom(fournisseurDto.getPrenom())
                .adresse(fournisseurDto.getAdresse())
                .photo(fournisseurDto.getPhoto())
                .mail(fournisseurDto.getMail())
                .numTel(fournisseurDto.getNumTel())
                .build();
    }

    public static Fournisseur toEntity(FournisseurDto fournisseurDto) {
        if(fournisseurDto == null) {
            //to do throug exception
            return  null ;
        }
        //ici c l inverse cad du Client dto vers Client
        Fournisseur fournisseur=new Fournisseur();
        fournisseur.setNom(fournisseur.getNom());
        fournisseur.setPrenom((fournisseur.getPrenom()));
        fournisseur.setAdresse(fournisseur.getAdresse());
        fournisseur.setPhoto((fournisseur.getPhoto()));
        fournisseur.setMail(fournisseur.getMail());
        fournisseur.setNumTel((fournisseur.getNumTel()));
        return fournisseur;
    }
}
