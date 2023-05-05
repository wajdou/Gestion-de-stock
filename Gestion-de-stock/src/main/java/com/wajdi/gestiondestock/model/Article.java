package com.wajdi.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="Article")
public class Article extends  AbstractEntity{

    @Column(name="codearticle")
    private String codeArticle;

    @Column(name="designation")
    private String designation;

    @Column(name="prix_unitaire_ht")
    private BigDecimal prixUnitaireHT;

    @Column(name="taux_tva")
    private BigDecimal tauxTva;

    @Column(name="prix_unitaire_ttc")
    private BigDecimal prixUnitaireTtc;

    @Column(name="photo")
    private String photo;

    @ManyToOne
    @JoinColumn(name ="idcategory" )
    private Categorie categorie;
}
