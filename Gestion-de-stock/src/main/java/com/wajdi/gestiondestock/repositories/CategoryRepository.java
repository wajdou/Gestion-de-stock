package com.wajdi.gestiondestock.repositories;

import com.wajdi.gestiondestock.model.Article;
import com.wajdi.gestiondestock.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Integer, Categorie> {
}
