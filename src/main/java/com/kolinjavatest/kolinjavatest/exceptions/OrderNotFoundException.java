package com.kolinjavatest.kolinjavatest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String exception) {
        super(exception);
    }
}
