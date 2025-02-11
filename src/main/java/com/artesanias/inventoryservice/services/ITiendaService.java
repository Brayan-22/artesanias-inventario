package com.artesanias.inventoryservice.services;

import com.artesanias.inventoryservice.dto.ProductoResponseDto;
import com.artesanias.inventoryservice.dto.TiendaResponseDto;
import com.artesanias.inventoryservice.exception.ProductosNotFoundException;
import com.artesanias.inventoryservice.exception.tiendanotfoundexception;

import java.util.List;

public interface ITiendaService {
    List<TiendaResponseDto> getTiendas()throws tiendanotfoundexception;
    List<ProductoResponseDto> getProductosByTienda(String idTienda) throws tiendanotfoundexception, ProductosNotFoundException;
}
