package com.wajdi.gestiondestock.repositories;

import com.wajdi.gestiondestock.model.Article;
import com.wajdi.gestiondestock.model.LigneCommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LigneCommandeClientRepository extends JpaRepository<LigneCommandeClient,Integer> {
}
