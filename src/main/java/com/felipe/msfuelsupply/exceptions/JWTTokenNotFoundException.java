package com.felipe.msfuelsupply.exceptions;

public class JWTTokenNotFoundException extends RuntimeException {
    public JWTTokenNotFoundException() {
        super("JWT token not found at request!");
    }
}
