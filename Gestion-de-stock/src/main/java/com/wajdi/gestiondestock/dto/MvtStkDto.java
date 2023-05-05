package com.wajdi.gestiondestock.dto;

import com.wajdi.gestiondestock.model.Article;
import com.wajdi.gestiondestock.model.LigneCommandeClient;
import com.wajdi.gestiondestock.model.MvtStk;
import com.wajdi.gestiondestock.model.TypeMvtStk;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
@Data
@Builder
public class MvtStkDto {

    private Integer id;

    private Instant dateMvt;

    private BigDecimal quantite;

    private ArticleDto article;

    private TypeMvtStk typeMvt;

    public static MvtStkDto fromEntity(MvtStk mvtStk) {
        if(mvtStk == null) {
            //to do throug exception
            return  null ;
        }
        //ici c l inverse cad du client dto vers client
        return  MvtStkDto.builder()
                .quantite(mvtStk.getQuantite())
                .build();
    }

    public static MvtStk toEntity(MvtStkDto mvtStkDto) {
        if(mvtStkDto == null) {
            //to do throug exception
            return  null ;
        }
        //ici c l inverse cad du Client dto vers Client
        MvtStk mvtStk=new MvtStk();
        mvtStk.setQuantite(mvtStkDto.getQuantite());
        return mvtStk;
    }
}
