package com.wajdi.gestiondestock.services;

import com.wajdi.gestiondestock.dto.CategorieDto;
import com.wajdi.gestiondestock.dto.ClientDto;

import java.util.List;

public interface ClientService {
    ClientDto save (ClientDto dto);
    ClientDto findById (Integer id);
    List<ClientDto> findAll();
    void delete (Integer id);
}
