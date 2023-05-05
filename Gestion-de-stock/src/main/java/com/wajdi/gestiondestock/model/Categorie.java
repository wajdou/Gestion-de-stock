package com.wajdi.gestiondestock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name="Categorie")
public class Categorie extends  AbstractEntity{
    @Column(name="code")
    private String code;

    @Column(name="designation")
    private String designation;

    @OneToMany(mappedBy = "categorie")
    private List<Article> articles;
}
