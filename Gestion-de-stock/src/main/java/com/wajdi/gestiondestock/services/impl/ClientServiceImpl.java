package com.wajdi.gestiondestock.services.impl;

import com.wajdi.gestiondestock.dto.CategorieDto;
import com.wajdi.gestiondestock.dto.ClientDto;
import com.wajdi.gestiondestock.execption.EntityNotFoundException;
import com.wajdi.gestiondestock.execption.ErrorCodes;
import com.wajdi.gestiondestock.model.Categorie;
import com.wajdi.gestiondestock.model.Client;
import com.wajdi.gestiondestock.repositories.ClientRepository;
import com.wajdi.gestiondestock.services.ClientService;
import com.wajdi.gestiondestock.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j

public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;
@Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDto save(ClientDto dto) {
        List<String> errors= ClientValidator.validate(dto);
        if(!errors.isEmpty()) {
            log.error("client is not valid{}", ErrorCodes.CLIENT_NOT_VALID,errors);
        }
        return ClientDto.fromEntity(clientRepository.save(ClientDto.toEntity(dto)));
    }

    @Override
    public ClientDto findById(Integer id) {
        if(id==null) {
            log.error(("Client ID is null"));
            return null;
        }
        Optional<Client> client=clientRepository.findById(id);

        return Optional.of(ClientDto.fromEntity(client.get())) .orElseThrow(()->new EntityNotFoundException
                ("Aucun client avec l ID="+id+"n a été trouvé dans la bd" , ErrorCodes.CLIENT_NOT_FOUND));
    }


    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream()
                .map(ClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id==null) {
            log.error(("client ID is null"));
            return ;
        }
        clientRepository.deleteById(id);


    }


}
