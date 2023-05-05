package com.wajdi.gestiondestock.dto;


import com.wajdi.gestiondestock.model.LigneCommandeClient;
import com.wajdi.gestiondestock.model.Roles;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RolesDto {

    private Integer id;

    private String roleName;

    private UtilisateurDto utilisateur;

    public static RolesDto fromEntity(Roles roles) {
        if(roles == null) {
            //to do throug exception
            return  null ;
        }
        //ici c l inverse cad du roles dto vers roles
        return  RolesDto.builder()
                .roleName(roles.getRoleName())
                .build();
    }

    public static Roles toEntity(RolesDto rolesDto) {
        if(rolesDto == null) {
            //to do throug exception
            return  null ;
        }
        //ici c l inverse cad du Roles dto vers Roles
        Roles roles=new Roles();
        roles.setRoleName(roles.getRoleName());
        return roles;
    }
}
