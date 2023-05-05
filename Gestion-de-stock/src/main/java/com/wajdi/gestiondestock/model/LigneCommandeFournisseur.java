package com.wajdi.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name="ligne_commande_fournisseur")
public class LigneCommandeFournisseur extends  AbstractEntity{

    @ManyToOne
    @JoinColumn(name="id_article")
    private Article article;

    @ManyToOne
    @JoinColumn(name="idCommandeFournisseur")
    private CommandeFournisseur commandeFournisseur;

    @Column(name = "quantite")
    private BigDecimal quantite;

    @Column(name = "prixUnitaire")
    private BigDecimal prixUnitaire;
}
