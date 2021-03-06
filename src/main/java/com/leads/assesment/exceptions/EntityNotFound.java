package com.leads.assesment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * If No Entity is found
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFound extends RuntimeException {
    public EntityNotFound(String s) {
        super(s);
    }
}
