package com.wajdi.gestiondestock.dto;

import com.wajdi.gestiondestock.model.Client;
import com.wajdi.gestiondestock.model.Utilisateur;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;
@Data
@Builder
public class UtilisateurDto {

    private Integer id;

    private String nom;

    private String prenom;

    private String email;

    private Instant dateDeNaissance;

    private String motDePasse;

    private AdresseDto adresse;

    private String photo;

    private EntrepriseDto entreprise;

    private List<RolesDto> roles;

    public static UtilisateurDto fromEntity(Utilisateur utilisateur) {
        if(utilisateur == null) {
            //to do throug exception
            return  null ;
        }
        //ici c l inverse cad du client dto vers client
        return  UtilisateurDto.builder()
                .nom(utilisateur.getNom())
                .photo(utilisateur.getPhoto())
                .prenom(utilisateur.getPrenom())
                .dateDeNaissance(utilisateur.getDateDeNaissance())
                .email(utilisateur.getEmail())
                .motDePasse(utilisateur.getMotDePasse())
                .build();
    }

    public static Utilisateur toEntity(UtilisateurDto utilisateurDto) {
        if(utilisateurDto == null) {
            //to do throug exception
            return  null ;
        }
        //ici c l inverse cad du Client dto vers Client
        Utilisateur utilisateur=new Utilisateur();
        utilisateur.setNom(utilisateurDto.getNom());
        utilisateur.setPhoto((utilisateurDto.getPhoto()));
        utilisateur.setPrenom(utilisateurDto.getPrenom());
        utilisateur.setDateDeNaissance(utilisateurDto.getDateDeNaissance());
        utilisateur.setEmail(utilisateurDto.getEmail());
        return utilisateur;
    }
}
