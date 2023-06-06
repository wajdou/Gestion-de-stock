package com.wajdi.gestiondestock.services.impl;

import com.wajdi.gestiondestock.dto.CategorieDto;
import com.wajdi.gestiondestock.dto.UtilisateurDto;
import com.wajdi.gestiondestock.execption.EntityNotFoundException;
import com.wajdi.gestiondestock.execption.ErrorCodes;
import com.wajdi.gestiondestock.model.Categorie;
import com.wajdi.gestiondestock.model.Utilisateur;
import com.wajdi.gestiondestock.repositories.UtilisteurRepository;
import com.wajdi.gestiondestock.services.UtilisateurService;
import com.wajdi.gestiondestock.validator.CategoryValidator;
import com.wajdi.gestiondestock.validator.UtilisateurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {
    private UtilisteurRepository utilisteurRepository;
    @Autowired
    public UtilisateurServiceImpl(UtilisteurRepository utilisteurRepository) {
        this.utilisteurRepository = utilisteurRepository;
    }

    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        List<String> errors= UtilisateurValidator.validate(dto);
        if(!errors.isEmpty()) {
            log.error("utilisateur is not valid{}", ErrorCodes.UTILISATEUR_NOT_VALID,errors);
        }
        return UtilisateurDto.fromEntity(utilisteurRepository.save(UtilisateurDto.toEntity(dto)));
    }

        @Override
    public UtilisateurDto findById(Integer id) {
        return null;
    }

    @Override
    public UtilisateurDto findByCodeUtilisateur(String code) {
        if(code==null) {
            log.error(("utilisateur ID is null"));
            return null;
        }
        Optional<Utilisateur> utilisateur=utilisteurRepository.findById(Integer.valueOf(code));

        return Optional.of(UtilisateurDto.fromEntity(utilisateur.get())) .orElseThrow(()->new EntityNotFoundException
                ("Aucun utilisateur avec le code ="+code+"n a été trouvé dans la bd" , ErrorCodes.UTILISATEUR_NOT_FOUND));
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisteurRepository.findAll().stream()
                .map(UtilisateurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id==null) {
            log.error(("utilisateur ID is null"));
            return ;
        }
        utilisteurRepository.deleteById(id);

    }
}
