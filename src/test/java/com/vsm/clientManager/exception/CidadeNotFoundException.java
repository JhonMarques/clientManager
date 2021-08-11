package com.vsm.clientManager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CidadeNotFoundException extends Exception{

    public CidadeNotFoundException(Integer id){
        super("Cidade com o ID: " + id + "não encontrado!");
    }
}
