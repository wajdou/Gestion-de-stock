package com.wajdi.gestiondestock.repositories;

import com.wajdi.gestiondestock.model.Article;
import com.wajdi.gestiondestock.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Categorie,Integer> {
    Optional< Categorie> findCategorieByCodeCategorie (String codeCategorie);
}
