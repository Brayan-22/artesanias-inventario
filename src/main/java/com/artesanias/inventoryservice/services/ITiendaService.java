package com.artesanias.inventoryservice.services;

import com.artesanias.inventoryservice.dto.ProductoResponseDto;
import com.artesanias.inventoryservice.dto.TiendaResponseDto;
import com.artesanias.inventoryservice.exception.ProductosNotFoundException;
import com.artesanias.inventoryservice.exception.Tiendanotfoundexception;

import java.util.List;

public interface ITiendaService {
    List<TiendaResponseDto> getTiendas()throws Tiendanotfoundexception;
    List<ProductoResponseDto> getProductosByTienda(String idTienda) throws Tiendanotfoundexception, ProductosNotFoundException;
}
