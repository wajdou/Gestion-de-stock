package com.wajdi.gestiondestock.dto;

import com.wajdi.gestiondestock.model.Client;
import com.wajdi.gestiondestock.model.CommandeClient;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;
@Data
@Builder
public class CommandeClientDto {

    private Integer id;

    private String code;

    private Instant dateCommande;

    private ClientDto client;

    private List<LigneCommandeClientDto> ligneCommandeClients;

    public static CommandeClientDto fromEntity(CommandeClient commandeClient) {
        if(commandeClient == null) {
            //to do throug exception
            return  null ;
        }
        //ici c l inverse cad du client dto vers client
        return  CommandeClientDto.builder()
                .code(commandeClient.getCode())
                .dateCommande(commandeClient.getDateCommande())
                .build();
    }

    public static CommandeClient toEntity(ClientDto clientDto) {
        if(clientDto == null) {
            //to do throug exception
            return  null ;
        }
        //ici c l inverse cad du Client dto vers Client
        CommandeClient commandeClient=new CommandeClient();
        commandeClient.setCode(commandeClient.getCode());
        commandeClient.setDateCommande((commandeClient.getDateCommande()));
        return commandeClient;
    }
}
