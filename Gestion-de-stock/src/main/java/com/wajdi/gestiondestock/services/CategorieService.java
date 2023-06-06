package com.wajdi.gestiondestock.services;

import com.wajdi.gestiondestock.dto.CategorieDto;

import java.util.List;

public interface CategorieService {
    CategorieDto save (CategorieDto dto);
    CategorieDto findById (Integer id);

    CategorieDto findByCodeCategorie (String code);
    List<CategorieDto> findAll();
    void delete (Integer id);
}
