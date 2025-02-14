package com.artesanias.inventoryservice.services;

import com.artesanias.inventoryservice.dto.*;
import com.artesanias.inventoryservice.exception.ProductoNotCreatedException;
import com.artesanias.inventoryservice.exception.ProductosNotFoundException;
import com.artesanias.inventoryservice.exception.Tiendanotfoundexception;

import java.util.List;

public interface ITiendaService {
    List<TiendaResponseDto> getTiendas()throws Tiendanotfoundexception;
    List<ProductoByTiendaResponseDto> getProductosByTienda(String idTienda) throws Tiendanotfoundexception, ProductosNotFoundException;

    DeleteProductoByTiendaResponseDto deleteProductoByTienda(String idTienda, DeleteProductoByTiendaRequestDto requestDto);
}
