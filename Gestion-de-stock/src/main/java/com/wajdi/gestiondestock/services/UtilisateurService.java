package com.wajdi.gestiondestock.services;

import com.wajdi.gestiondestock.dto.CategorieDto;
import com.wajdi.gestiondestock.dto.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {
    UtilisateurDto save (UtilisateurDto dto);
    UtilisateurDto findById (Integer id);

    UtilisateurDto findByCodeUtilisateur (String code);
    List<UtilisateurDto> findAll();
    void delete (Integer id);
}
