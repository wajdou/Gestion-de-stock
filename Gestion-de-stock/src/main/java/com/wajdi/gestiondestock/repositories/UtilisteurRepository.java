package com.wajdi.gestiondestock.repositories;

import com.wajdi.gestiondestock.model.Article;
import com.wajdi.gestiondestock.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisteurRepository extends JpaRepository<Integer, Utilisateur> {
}
