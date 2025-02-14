package com.artesanias.inventoryservice.controller;

import com.artesanias.inventoryservice.dto.AlmacenResponseDto;
import com.artesanias.inventoryservice.dto.UpdateAlmacenDto;
import com.artesanias.inventoryservice.services.IAlmacenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/almacen")
@RequiredArgsConstructor
public class AlmacenesController {

    private final IAlmacenService almacenService;

    @GetMapping("/tienda/{idTienda}")
    public ResponseEntity<List<AlmacenResponseDto>> getAlmacenByTienda(@PathVariable String idTienda){
        return ResponseEntity.ok(almacenService.getAlmacenByTienda(idTienda));
    }

    @GetMapping("/{idAlmacen}")
    public ResponseEntity<AlmacenResponseDto> getAlmacenById(@PathVariable String idAlmacen){
        return ResponseEntity.ok(almacenService.getAlmacenById(idAlmacen));
    }

    @PatchMapping("/{idAlmacen}")
    public ResponseEntity<AlmacenResponseDto> updateAlmacen(String idAlmacen, UpdateAlmacenDto almacen){
        return ResponseEntity.ok(almacenService.updateAlmacen(idAlmacen, almacen));
    }

}
