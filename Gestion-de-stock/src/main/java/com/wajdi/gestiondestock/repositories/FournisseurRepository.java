package com.wajdi.gestiondestock.repositories;

import com.wajdi.gestiondestock.model.Article;
import com.wajdi.gestiondestock.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<Integer, Fournisseur> {
}
