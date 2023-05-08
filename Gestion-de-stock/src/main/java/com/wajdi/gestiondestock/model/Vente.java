package com.wajdi.gestiondestock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name="vente")
public class Vente extends AbstractEntity{

    @Column(name = "code")
    private String code;

    @Column(name = "date_vente")
    private Instant dateVente;

    @Column(name = "id_entreprise")
    private Integer idEntreprise;

    @Column(name = "commantaire")
    private  String commantaire;
}
