package com.felipe.msfuelsupply.exceptions;

public class FieldAlreadyInUseException extends RuntimeException {

    public FieldAlreadyInUseException(String field, String value) {
        super(String.format("Error in the field '%s', the value '%s' is already in use!", field, value));
    }
}
