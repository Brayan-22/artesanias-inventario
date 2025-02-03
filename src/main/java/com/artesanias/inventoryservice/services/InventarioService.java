package com.artesanias.inventoryservice.services;

import com.artesanias.inventoryservice.dto.ProductoDisponibleResponseDto;
import com.artesanias.inventoryservice.exception.ProductosNotFoundException;
import com.artesanias.inventoryservice.exception.SedeNotFoundException;

import java.util.List;

public interface InventarioService {
    List<ProductoDisponibleResponseDto> getProductosTodasSedes(Integer page,Integer size) throws ProductosNotFoundException;
    List<ProductoDisponibleResponseDto> getProductosBySede(Integer page,Integer size,String idSede)throws ProductosNotFoundException, SedeNotFoundException;
    List<ProductoDisponibleResponseDto> getProductosTotalesCentral(Integer page,Integer size)throws ProductosNotFoundException;
    List<ProductoDisponibleResponseDto> getProductosByCentral(Integer page,Integer size) throws ProductosNotFoundException;
}
