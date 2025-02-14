package com.artesanias.inventoryservice.controller;

import com.artesanias.inventoryservice.dto.*;
import com.artesanias.inventoryservice.services.ITiendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<ProductoByTiendaResponseDto>> getProductosByTienda(@PathVariable String idTienda){
        return ResponseEntity.ok(tiendaService.getProductosByTienda(idTienda));
    }

    @DeleteMapping("/producto/{idTienda}")
    public ResponseEntity<?> deleteProductoByTienda(@PathVariable String idTienda,@RequestBody DeleteProductoByTiendaRequestDto requestDto){
        return ResponseEntity.ok(tiendaService.deleteProductoByTienda(idTienda,requestDto));
    }


}
