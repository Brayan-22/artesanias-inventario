package com.artesanias.inventoryservice.exception;

public class ProductosNotFoundException extends RuntimeException {
    public ProductosNotFoundException(String message) {
        super(message);
    }
}
