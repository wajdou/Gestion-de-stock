package com.wajdi.gestiondestock.services;

import com.wajdi.gestiondestock.dto.CategorieDto;
import com.wajdi.gestiondestock.dto.FournisseurDto;

import java.util.List;

public interface FournisseurService {
    FournisseurDto save (FournisseurDto dto);
    FournisseurDto findById (Integer id);

    FournisseurDto findByCodeFournisseur (String code);
    List<FournisseurDto> findAll();
    void delete (Integer id);
}
