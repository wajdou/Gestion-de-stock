package com.wajdi.gestiondestock.repositories;

import com.wajdi.gestiondestock.model.Article;
import com.wajdi.gestiondestock.model.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface CommandeClientRepository extends JpaRepository<CommandeClient,Integer> {

    Optional< CommandeClient> findArticleByCodeCommandeClient (String code);

}
