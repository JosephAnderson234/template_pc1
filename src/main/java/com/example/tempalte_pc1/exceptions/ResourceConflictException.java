package com.example.tempalte_pc1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ResourceConflictException extends ResponseStatusException {

    public ResourceConflictException(String message) {
        super(HttpStatus.CONFLICT, message);
    }

    public ResourceConflictException() {
        this("Conflict");
    }

}
