package com.wajdi.gestiondestock.dto;

import com.wajdi.gestiondestock.model.Utilisateur;
import com.wajdi.gestiondestock.model.Vente;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
@Data
@Builder
public class VenteDto {

    private Integer id;

    private String code;

    private Instant dateVente;

    private  String commantaire;


    public static VenteDto fromEntity(Vente vente) {
        if(vente == null) {
            //to do throug exception
            return  null ;
        }
        //ici c l inverse cad du vente dto vers vente
        return  VenteDto.builder()
                .code(vente.getCode())
                .dateVente(vente.getDateVente())
                .commantaire(vente.getCommantaire())
                .build();
    }

    public static Vente toEntity(VenteDto venteDto) {
        if(venteDto == null) {
            //to do throug exception
            return  null ;
        }
        //ici c l inverse cad du vente dto vers vente
        Vente vente=new Vente();
        vente.setDateVente(venteDto.getDateVente());
        vente.setCommantaire((vente.getCommantaire() ));
        return vente;
    }
}
