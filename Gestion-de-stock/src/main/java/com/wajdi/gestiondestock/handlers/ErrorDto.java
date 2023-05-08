package com.wajdi.gestiondestock.handlers;

import com.wajdi.gestiondestock.execption.ErrorCodes;
import com.wajdi.gestiondestock.model.Article;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorDto {

    private Integer httpCode;
    private ErrorCodes errorCodes;
    private  String message;
    private List<String> errors=new ArrayList<>();
}
