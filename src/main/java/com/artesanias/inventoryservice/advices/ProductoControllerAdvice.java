package com.artesanias.inventoryservice.advices;

import com.artesanias.inventoryservice.exception.ProductosNotFoundException;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Hidden
public class ProductoControllerAdvice {
    @ExceptionHandler(ProductosNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductosNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}