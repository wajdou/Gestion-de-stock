package com.wajdi.gestiondestock.dto;

import com.wajdi.gestiondestock.model.Adresse;
import com.wajdi.gestiondestock.model.Categorie;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AdresseDto {

    private String adresse1;

    private String adresse2;

    private String ville;

    private String codePostale;

    private String pays;

    public static AdresseDto fromEntity(Adresse adresse) {
        if(adresse == null) {
            //to do throug exception
            return  null ;
        }
        //ici c l inverse cad du categorie dto vers categorie
        return  AdresseDto.builder()
                .adresse1(adresse.getAdresse1())
                .adresse2(adresse.getAdresse2())
                .codePostale(adresse.getCodePostale())
                .ville(adresse.getVille())
                .pays(adresse.getPays())
                .build();
    }

    public static Adresse toEntity(AdresseDto adresseDto) {
        if(adresseDto == null) {
            //to do throug exception
            return  null ;
        }
        //ici c l inverse cad du categorie dto vers categorie
        Adresse adresse=new Adresse();
        adresse.setAdresse1(adresseDto.getAdresse1());
        adresse.setAdresse2((adresseDto.getAdresse2()));
        adresse.setCodePostale(adresseDto.getCodePostale());
        adresse.setVille(adresseDto.getVille());
        adresse.setPays(adresseDto.getPays());
        return adresse;
    }
}
