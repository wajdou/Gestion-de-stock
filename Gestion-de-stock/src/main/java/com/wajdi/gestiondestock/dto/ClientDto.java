package com.wajdi.gestiondestock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wajdi.gestiondestock.model.Adresse;

import com.wajdi.gestiondestock.model.Client;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class ClientDto {

    private Integer id;

    private String nom;

    private String prenom;

    private Adresse adresse;

    private String photo;

    private String mail;

    private String numTel;
    @JsonIgnore
    private List<CommandeClientDto> commandeClients;

    public static ClientDto fromEntity(Client client) {
        if(client == null) {
            //to do throug exception
            return  null ;
        }
        //ici c l inverse cad du client dto vers client
        return  ClientDto.builder()
                .nom(client.getNom())
                .photo(client.getPhoto())
                .prenom(client.getPrenom())
                .adresse(client.getAdresse())
                .mail(client.getMail())
                .build();
    }

    public static Client toEntity(ClientDto clientDto) {
        if(clientDto == null) {
            //to do throug exception
            return  null ;
        }
        //ici c l inverse cad du Client dto vers Client
        Client client=new Client();
        client.setNom(clientDto.getNom());
        client.setPhoto((clientDto.getPhoto()));
        client.setPrenom(clientDto.getPrenom());
        client.setAdresse(clientDto.getAdresse());
        client.setMail(clientDto.getMail());
        return client;
    }

}
