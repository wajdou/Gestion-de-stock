package com.wajdi.gestiondestock.services;

import com.wajdi.gestiondestock.dto.CategorieDto;
import com.wajdi.gestiondestock.dto.CommandeClientDto;

import java.util.List;

public interface CommandeClientService {
    CommandeClientDto save (CommandeClientDto dto);
    CommandeClientDto findById (Integer id);

    CommandeClientDto findByCode (String code);
    List<CommandeClientDto> findAll();
    void delete (Integer id);
}
