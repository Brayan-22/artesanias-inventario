package com.artesanias.inventoryservice.exception;

public class AlmacenNotFoundException extends RuntimeException {
    public AlmacenNotFoundException(String message) {
        super(message);
    }
}
