package com.wajdi.gestiondestock.dto;

import com.wajdi.gestiondestock.model.Article;
import com.wajdi.gestiondestock.model.LigneVente;
import com.wajdi.gestiondestock.model.Vente;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
@Data
@Builder
public class LigneVenteDto {

    private Integer id;

    private VenteDto vente;

    private BigDecimal quantite;

    private BigDecimal prixUnitaire;

    public static LigneVenteDto fromEntity(LigneVente ligneVente) {
        if(ligneVente == null) {
            //to do throug exception
            return  null ;
        }
        //ici c l inverse cad du article dto vers article
        return  LigneVenteDto.builder()
                .quantite(ligneVente.getQuantite())
                .prixUnitaire(ligneVente.getPrixUnitaire())
                .build();
    }

    public static LigneVente toEntity(LigneVenteDto ligneVenteDto) {
        if(ligneVenteDto == null) {
            //to do throug exception
            return  null ;
        }
        //ici c l inverse cad du categorie dto vers categorie
        LigneVente ligneVente=new LigneVente();
        ligneVente.setPrixUnitaire(ligneVenteDto.getPrixUnitaire());
        ligneVente.setQuantite((ligneVenteDto.getQuantite()));
        return ligneVente;
    }
}
