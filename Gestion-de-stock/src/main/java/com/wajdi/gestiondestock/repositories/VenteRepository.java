package com.wajdi.gestiondestock.repositories;

import com.wajdi.gestiondestock.model.Article;
import com.wajdi.gestiondestock.model.Vente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VenteRepository extends JpaRepository<Vente,Integer> {
}
