package com.wajdi.gestiondestock.dto;

import com.wajdi.gestiondestock.model.CommandeClient;
import com.wajdi.gestiondestock.model.CommandeFournisseur;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;
@Data
@Builder
public class CommandeFournisseurDto {

    private Integer id;

    private String code;

    private Instant dateCommande;

    private FournisseurDto fournisseur;


    private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs;

    public static CommandeFournisseurDto fromEntity(CommandeFournisseur commandeFournisseur) {
        if(commandeFournisseur == null) {
            //to do throug exception
            return  null ;
        }
        //ici c l inverse cad du client dto vers client
        return  CommandeFournisseurDto.builder()
                .code(commandeFournisseur.getCode())
                .dateCommande(commandeFournisseur.getDateCommande())
                .build();
    }

    public static CommandeFournisseur toEntity(FournisseurDto fournisseurDto) {
        if(fournisseurDto == null) {
            //to do throug exception
            return  null ;
        }
        //ici c l inverse cad du Client dto vers Client
        CommandeFournisseur commandeFournisseur=new CommandeFournisseur();
        commandeFournisseur.setCode(commandeFournisseur.getCode());
        commandeFournisseur.setDateCommande((commandeFournisseur.getDateCommande()));
        return commandeFournisseur;
    }
}
