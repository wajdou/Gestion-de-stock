package com.wajdi.gestiondestock.handlers;

import com.wajdi.gestiondestock.execption.EntityNotFoundException;
import com.wajdi.gestiondestock.execption.InvalidEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

@ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDto> handleException(EntityNotFoundException exception, WebRequest webRequest) {

    final HttpStatus notfound=HttpStatus.NOT_FOUND;
    final  ErrorDto errorDto =ErrorDto.builder()
            .errorCodes(exception.getErrorCodes())
            .httpCode(notfound.value())
            .message(exception.getMessage())
            .build();

        return new ResponseEntity<>(errorDto,notfound);
    }

    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<ErrorDto> handleException(InvalidEntityException exception, WebRequest webRequest) {
        final HttpStatus badRequest=HttpStatus.BAD_REQUEST;

        final  ErrorDto errorDto=ErrorDto.builder()
                .errorCodes(exception.getErrorCodes())
                .httpCode(badRequest.value())
                .message(exception.getMessage())
                .errors((exception.getErrors()))
                .build();

        return new ResponseEntity<>(errorDto,badRequest);
    }

}
