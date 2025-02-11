package com.artesanias.inventoryservice.controller;

import com.artesanias.inventoryservice.dto.ProductoResponseDto;
import com.artesanias.inventoryservice.dto.TiendaResponseDto;
import com.artesanias.inventoryservice.services.ITiendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tienda")
@RequiredArgsConstructor
public class TiendaController {

    private final ITiendaService tiendaService;

    @GetMapping("/all")
    public ResponseEntity<List<TiendaResponseDto>> getTiendas(){
        return ResponseEntity.ok(tiendaService.getTiendas());
    }

    @GetMapping("/productos/{idTienda}")
    public ResponseEntity<List<ProductoResponseDto>> getProductosByTienda(String idTienda){
        return ResponseEntity.ok(tiendaService.getProductosByTienda(idTienda));
    }

}
