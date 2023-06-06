package com.wajdi.gestiondestock.services.impl;

import com.wajdi.gestiondestock.dto.CategorieDto;
import com.wajdi.gestiondestock.execption.EntityNotFoundException;
import com.wajdi.gestiondestock.execption.ErrorCodes;
import com.wajdi.gestiondestock.model.Categorie;
import com.wajdi.gestiondestock.repositories.CategoryRepository;
import com.wajdi.gestiondestock.services.CategorieService;
import com.wajdi.gestiondestock.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategorieServiceImpl implements CategorieService {

    private CategoryRepository categoryRepository;
@Autowired
    public CategorieServiceImpl(CategoryRepository categoryRepository) {

    this.categoryRepository = categoryRepository;
    }

    @Override
    public CategorieDto save(CategorieDto dto) {
        List<String> errors= CategoryValidator.validate(dto);
        if(!errors.isEmpty()) {
            log.error("Categorie is not valid{}", ErrorCodes.CATEGORIE_NOT_VALID,errors);
        }

        return CategorieDto.fromEntity(categoryRepository.save(CategorieDto.toEntity(dto)));
}

    @Override
    public CategorieDto findById(Integer id) {
        if(id==null) {
            log.error(("Categorie ID is null"));
            return null;
        }
        Optional<Categorie> categorie=categoryRepository.findById(id);

        return Optional.of(CategorieDto.fromEntity(categorie.get())) .orElseThrow(()->new EntityNotFoundException
                ("Aucune Categorie avec l ID="+id+"n a été trouvé dans la bd" , ErrorCodes.CATEGORIE_NOT_FOUND));
}

    @Override
    public CategorieDto findByCodeCategorie(String code) {
        if(!StringUtils.hasLength(code)) {
            log.error(("Categorie CODE is null"));
            return null;
        }
        Optional <Categorie> categorie=categoryRepository.findCategorieByCodeCategorie(code);

        return Optional.of(CategorieDto.fromEntity(categorie.get())) .orElseThrow(()->new EntityNotFoundException
                ("Aucune categorie avec le code ="+code+"n a été trouvé dans la bd" , ErrorCodes.CATEGORIE_NOT_FOUND));
    }

    @Override
    public List<CategorieDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategorieDto::fromEntity)
                .collect(Collectors.toList());
        }

    @Override
    public void delete(Integer id) {
        if(id==null) {
            log.error(("Categorie ID is null"));
            return ;
        }
        categoryRepository.deleteById(id);

    }
}
