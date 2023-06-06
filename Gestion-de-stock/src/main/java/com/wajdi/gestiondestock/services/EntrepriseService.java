package com.wajdi.gestiondestock.services;

import com.wajdi.gestiondestock.dto.ArticleDto;
import com.wajdi.gestiondestock.dto.EntrepriseDto;

import java.util.List;

public interface EntrepriseService {
    EntrepriseDto save (EntrepriseDto dto);
    EntrepriseDto findById (Integer id);

    EntrepriseDto findByCodeEntreprise (String code);
    List<EntrepriseDto> findAll();
    void delete (Integer id);
}
