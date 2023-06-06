package com.wajdi.gestiondestock.services.impl;

import com.wajdi.gestiondestock.dto.CategorieDto;
import com.wajdi.gestiondestock.dto.EntrepriseDto;
import com.wajdi.gestiondestock.execption.EntityNotFoundException;
import com.wajdi.gestiondestock.execption.ErrorCodes;
import com.wajdi.gestiondestock.model.Categorie;
import com.wajdi.gestiondestock.model.Entreprise;
import com.wajdi.gestiondestock.repositories.EntrepriseRepository;
import com.wajdi.gestiondestock.services.EntrepriseService;
import com.wajdi.gestiondestock.validator.CategoryValidator;
import com.wajdi.gestiondestock.validator.EntrepriseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {
    private EntrepriseRepository entrepriseRepository;
    @Autowired

    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository) {
        this.entrepriseRepository = entrepriseRepository;
    }


    @Override
    public EntrepriseDto save(EntrepriseDto dto) {
        List<String> errors= EntrepriseValidator.validate(dto);
        if(!errors.isEmpty()) {
            log.error("entreprise is not valid{}", ErrorCodes.ENTREPRISE_NOT_VALID,errors);
        }

        return EntrepriseDto.fromEntity(entrepriseRepository.save(EntrepriseDto.toEntity(dto)));
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        if(id==null) {
            log.error(("entreprise ID is null"));
            return null;
        }
        Optional<Entreprise> entreprise=entrepriseRepository.findById(id);

        return Optional.of(EntrepriseDto.fromEntity(entreprise.get())) .orElseThrow(()->new EntityNotFoundException
                ("Aucune entreprise avec l ID="+id+"n a été trouvé dans la bd" , ErrorCodes.CATEGORIE_NOT_FOUND));
    }

    @Override
    public EntrepriseDto findByCodeEntreprise(String code) {
        if(!StringUtils.hasLength(code)) {
            log.error(("entreprise CODE is null"));
            return null;
        }
        Optional <Entreprise> entreprise=entrepriseRepository.findArticleByCodeEntrprise(code);

        return Optional.of(EntrepriseDto.fromEntity(entreprise.get())) .orElseThrow(()->new EntityNotFoundException
                ("Aucune entreprise avec le code ="+code+"n a été trouvé dans la bd" , ErrorCodes.ENTREPRISE_NOT_FOUND));
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseRepository.findAll().stream()
                .map(EntrepriseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id==null) {
            log.error(("entreprise ID is null"));
            return ;
        }
        entrepriseRepository.deleteById(id);
    }
}
