package com.wajdi.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name="roles")
public class Roles extends  AbstractEntity{

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "id_entreprise")
    private Integer idEntreprise;

    @ManyToOne
    @JoinColumn(name="idutilisateur")
    private Utilisateur utilisateur;
}
