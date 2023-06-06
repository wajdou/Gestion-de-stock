package com.wajdi.gestiondestock.repositories;

import com.wajdi.gestiondestock.model.Article;
import com.wajdi.gestiondestock.model.Entreprise;
import com.wajdi.gestiondestock.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface UtilisteurRepository extends JpaRepository<Utilisateur,Integer> {
    Optional<Utilisateur> findArticleByCodeUtilisateur (String code);
}
