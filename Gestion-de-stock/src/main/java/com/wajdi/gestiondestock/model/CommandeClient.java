package com.wajdi.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name="commande-client")
public class CommandeClient extends AbstractEntity{
    @Column(name = "code")
    private String code;

    @Column(name = "date_commande")
    private Instant dateCommande;
    @ManyToOne
    @JoinColumn(name = "idclient")
    private Client client;

    @Column(name = "id_entreprise")
    private Integer idEntreprise;

    @OneToMany(mappedBy = "commandeClient")
    private List<LigneCommandeClient> ligneCommandeClients;
}
