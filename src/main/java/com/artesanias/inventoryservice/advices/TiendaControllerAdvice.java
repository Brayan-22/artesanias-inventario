package com.artesanias.inventoryservice.advices;

import com.artesanias.inventoryservice.exception.tiendanotfoundexception;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Hidden
public class TiendaControllerAdvice {
    @ExceptionHandler(tiendanotfoundexception.class)
    public ResponseEntity<String> handleSedeNotFoundException(tiendanotfoundexception ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
