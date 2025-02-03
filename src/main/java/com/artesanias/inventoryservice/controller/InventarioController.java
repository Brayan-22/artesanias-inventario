package com.artesanias.inventoryservice.controller;

import com.artesanias.inventoryservice.dto.ProductoDisponibleResponseDto;
import com.artesanias.inventoryservice.repository.InventarioRepository;
import com.artesanias.inventoryservice.services.InventarioService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class InventarioController {
    private final InventarioService inventarioService;

    @GetMapping(path = {"/all"},produces = "application/json")
    public ResponseEntity<?> getProductosTodasSedes(@RequestParam Integer page,
                                                    @RequestParam Integer size){
        return ResponseEntity.ok(inventarioService.getProductosTodasSedes(page,size));
    }

    @GetMapping(value = "/sucursal/{idsucursal}",produces = "application/json",path = "/sucursal/{idsucursal}")
    public ResponseEntity<?> getProductosBySede(@RequestParam Integer page,
                                               @RequestParam Integer size,
                                               @Parameter(description = "Id sucursal",required = true)
                                                    @PathVariable String idsucursal){
        return ResponseEntity.ok(inventarioService.getProductosBySede(page,size,idsucursal));
    }

    @GetMapping(value = "/central/all",produces = "application/json")
    public ResponseEntity<?> getProductosTotalesCentral(
            @RequestParam Integer page,
            @RequestParam Integer size
    ){
        return ResponseEntity.ok(inventarioService.getProductosTotalesCentral(page,size));
    }

    @GetMapping(value = "/central",produces = "application/json")
    public ResponseEntity<?> getProductosByCentral(
            @RequestParam Integer page,
            @RequestParam Integer size
    ){
        return ResponseEntity.ok(inventarioService.getProductosByCentral(page,size));
    }
}
