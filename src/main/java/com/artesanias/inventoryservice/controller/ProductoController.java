package com.artesanias.inventoryservice.controller;

import com.artesanias.inventoryservice.dto.CreateProductoRequestDto;
import com.artesanias.inventoryservice.services.IProductoService;
import com.artesanias.inventoryservice.services.ITiendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")
@RequiredArgsConstructor
public class ProductoController {

    private final IProductoService productoService;
    @PostMapping("/save")
    public ResponseEntity<?> createProducto(@RequestBody CreateProductoRequestDto request){
        return ResponseEntity.ok(productoService.createProducto(request));
    }

    @PutMapping("/update/{idproducto}")
    public ResponseEntity<?> updateProducto(@PathVariable String idproducto,@RequestBody CreateProductoRequestDto request){
        return ResponseEntity.ok(productoService.updateProducto(idproducto,request));
    }
}
