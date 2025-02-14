package com.artesanias.inventoryservice.exception;

public class ProductoNotCreatedException extends RuntimeException {
    public ProductoNotCreatedException(String message) {
        super(message);
    }
}
