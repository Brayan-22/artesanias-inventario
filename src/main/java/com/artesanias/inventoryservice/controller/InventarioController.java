package com.artesanias.inventoryservice.controller;

import com.artesanias.inventoryservice.dto.ProductoDisponibleResponseDto;
import com.artesanias.inventoryservice.repository.InventarioRepository;
import com.artesanias.inventoryservice.services.InventarioService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/inventario")
public class InventarioController {
    private final InventarioService inventarioService;

    @GetMapping(path = {"/all"},produces = "application/json")
    public ResponseEntity<?> getProductosTodasSedes(@RequestParam Integer page,
                                                    @RequestParam Integer size){
        return ResponseEntity.ok(inventarioService.getProductosTodasSedes(page,size));
    }

    @GetMapping(value = "/tienda/{idTienda}",produces = "application/json",path = "/tienda/{idTienda}")
    public ResponseEntity<?> getProductosByTienda(@RequestParam Integer page,
                                               @RequestParam Integer size,
                                               @Parameter(description = "Id tienda",required = true)
                                                    @PathVariable String idTienda){
        return ResponseEntity.ok(inventarioService.getProductosBySede(page,size,idTienda));
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

    @GetMapping(value = "/catalogo/almacen/{idalmacen}",produces = "application/json")
    public ResponseEntity<?> getCatalogoByAlmacen(@PathVariable String idalmacen,
                                                  @RequestParam(required = false) Integer page,
                                                  @RequestParam(required = false) Integer size){
        return ResponseEntity.ok(inventarioService.getCatalogoByAlmacen(idalmacen,page,size));
    }

    @GetMapping(value = "/almacen/{idalmacen}",produces = "application/json")
    public ResponseEntity<?> getInventarioByAlmacen(@PathVariable String idalmacen,
                                                    @RequestParam(required = false) Integer page,
                                                   @RequestParam(required = false) Integer size){
        return ResponseEntity.ok(inventarioService.getInventarioByAlmacen(idalmacen,page,size));
    }
}
