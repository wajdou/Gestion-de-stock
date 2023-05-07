package com.wajdi.gestiondestock.repositories;

import com.wajdi.gestiondestock.model.Article;
import com.wajdi.gestiondestock.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Integer, Client> {
}
