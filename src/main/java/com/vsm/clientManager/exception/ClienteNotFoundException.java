package com.vsm.clientManager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClienteNotFoundException extends Exception{

    public ClienteNotFoundException(Integer id){
        super("Cliente com o ID: " + id + "não encontrado!");
    }
}
