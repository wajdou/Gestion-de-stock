package com.wajdi.gestiondestock.services.impl;

import com.wajdi.gestiondestock.dto.ArticleDto;
import com.wajdi.gestiondestock.dto.CommandeClientDto;
import com.wajdi.gestiondestock.execption.ErrorCodes;
import com.wajdi.gestiondestock.execption.InvalidEntityException;
import com.wajdi.gestiondestock.model.Article;
import com.wajdi.gestiondestock.model.Client;
import com.wajdi.gestiondestock.model.CommandeClient;
import com.wajdi.gestiondestock.repositories.ArticleRepository;
import com.wajdi.gestiondestock.repositories.ClientRepository;
import com.wajdi.gestiondestock.repositories.CommandeClientRepository;
import com.wajdi.gestiondestock.services.CommandeClientService;
import com.wajdi.gestiondestock.validator.ArticleValidator;
import com.wajdi.gestiondestock.validator.CommadeClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CommandeClientServieImpl implements CommandeClientService {
    private CommandeClientRepository commandeClientRepository;
    private ClientRepository clientRepository;
    private ArticleRepository articleRepository;
@Autowired
    public CommandeClientServieImpl(CommandeClientRepository commandeClientRepository, ClientRepository clientRepository, ArticleRepository articleRepository) {
        this.commandeClientRepository = commandeClientRepository;
        this.clientRepository = clientRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public CommandeClientDto save(CommandeClientDto dto) {
        List<String> errors= CommadeClientValidator.validate(dto);
        if(!errors.isEmpty()) {
            log.error("Commande client  is not valid{}", ErrorCodes.COMMANDE_CLIENT_NOT_VALID,errors);
        }
    Optional<Client>  client=clientRepository.findById(dto.getClient().getId());
        if(client.isEmpty()) {
            log.warn("client with ID {} was not found in the db"+dto.getClient().getId()+"n a ete trouvé dans la bd");
        }
        List<String> articlesErrors=new ArrayList<>();

        if(dto.getLigneCommandeClients()!=null){
    dto.getLigneCommandeClients().forEach(ligCmClt -> {
            if(ligCmClt.getArticle()!=null) {
                Optional<Article>  article=articleRepository.findById(ligCmClt.getArticle().getId());
                if(article.isEmpty()){
                    articlesErrors.add(("l article avec l ID "+ligCmClt.getArticle().getId()+"n existe pas"));
                }

            }

    });
}
        if(!articlesErrors.isEmpty()) {
            log.warn("");
            throw new InvalidEntityException("Article n existe pas dans la bd",ErrorCodes.ARTICLE_NOT_FOUND,articlesErrors);
        }
        CommandeClient savedCmdClt=commandeClientRepository.save(CommandeClientDto.toEntity(dto.getClient()));

return null;
}

    @Override
    public CommandeClientDto findById(Integer id) {
        return null;
    }

    @Override
    public CommandeClientDto findByCode(String code) {
        return null;
    }

    @Override
    public List<CommandeClientDto> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
