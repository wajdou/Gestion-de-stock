package com.wajdi.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name="Client")
public class Client extends AbstractEntity{
    @Column(name="nom")
    private String nom;

    @Column(name="prenom")
    private String prenom;

  //  private String adresse;
    @Embedded
    private  Adresse adresse;
    @Column(name="photo")
    private String photo;

    @Column(name="mail")
    private String mail;

    @Column(name="numtel")
    private String numTel;

    @Column(name = "id_entreprise")
    private Integer idEntreprise;

    @OneToMany(mappedBy = "client")
    private List<CommandeClient> commandeClients;
}
