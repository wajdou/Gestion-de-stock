package com.wajdi.gestiondestock.services.impl;

import com.wajdi.gestiondestock.dto.CategorieDto;
import com.wajdi.gestiondestock.dto.FournisseurDto;
import com.wajdi.gestiondestock.execption.EntityNotFoundException;
import com.wajdi.gestiondestock.execption.ErrorCodes;
import com.wajdi.gestiondestock.model.Fournisseur;
import com.wajdi.gestiondestock.repositories.FournisseurRepository;
import com.wajdi.gestiondestock.services.FournisseurService;
import com.wajdi.gestiondestock.validator.FournisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FournisseurServiceImpl implements FournisseurService {
    private FournisseurRepository fournisseurRepository;
@Autowired
    public FournisseurServiceImpl(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    @Override
    public FournisseurDto save(FournisseurDto dto) {
        List<String> errors= FournisseurValidator.validate(dto);
        if(!errors.isEmpty()) {
            log.error("fournisseur is not valid{}", ErrorCodes.FOURNISSEUR_NOT_VALID,errors);
        }

        return FournisseurDto.fromEntity(fournisseurRepository.save(FournisseurDto.toEntity(dto)));
}

    @Override
    public FournisseurDto findById(Integer id) {
        if(id==null) {
            log.error(("fournisseur ID is null"));
            return null;
        }
        Optional<Fournisseur> fournisseur=fournisseurRepository.findById(id);

        return Optional.of(FournisseurDto.fromEntity(fournisseur.get())) .orElseThrow(()->new EntityNotFoundException
                ("Aucun fournisseur avec l ID="+id+"n a été trouvé dans la bd" , ErrorCodes.FOURNISSEUR_NOT_FOUND));
}

    @Override
    public FournisseurDto findByCodeFournisseur(String code) {
        if(!StringUtils.hasLength(code)) {
            log.error(("Categorie CODE is null"));
            return null;
        }
        Optional <Fournisseur> fournisseur=fournisseurRepository.findArticleByCodeFournisseur(code);

        return Optional.of(FournisseurDto.fromEntity(fournisseur.get())) .orElseThrow(()->new EntityNotFoundException
                ("Aucun fournisseur avec le code ="+code+"n a été trouvé dans la bd" , ErrorCodes.FOURNISSEUR_NOT_FOUND));
}

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurRepository.findAll().stream()
                .map(FournisseurDto::fromEntity)
                .collect(Collectors.toList());
}

    @Override
    public void delete(Integer id) {
        if(id==null) {
            log.error(("fournisseur ID is null"));
            return ;
        }
        fournisseurRepository.deleteById(id);
    }
}
