package com.wajdi.gestiondestock.repositories;

import com.wajdi.gestiondestock.model.Article;
import com.wajdi.gestiondestock.model.Categorie;
import com.wajdi.gestiondestock.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client,Integer> {
    Optional<Client> findClientByCodeClient (String codeClient);
}
