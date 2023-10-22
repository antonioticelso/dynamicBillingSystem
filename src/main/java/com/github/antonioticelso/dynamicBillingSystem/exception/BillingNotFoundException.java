package com.github.antonioticelso.dynamicBillingSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class BillingNotFoundException extends RuntimeException {

    public BillingNotFoundException() {
        super("Billing not found. ");
    }

}
