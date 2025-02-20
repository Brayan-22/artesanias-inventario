package com.artesanias.inventoryservice.services;

import com.artesanias.inventoryservice.dto.*;
import com.artesanias.inventoryservice.exception.AlmacenNotFoundException;
import com.artesanias.inventoryservice.exception.InventarioNotUpdatedException;
import com.artesanias.inventoryservice.exception.ProductosNotFoundException;
import com.artesanias.inventoryservice.exception.Tiendanotfoundexception;

import java.util.List;

public interface InventarioService {
    List<ProductoDisponibleResponseDto> getProductosTodasSedes(Integer page,Integer size) throws ProductosNotFoundException;
    List<ProductoDisponibleResponseDto> getProductosBySede(Integer page,Integer size,String idSede)throws ProductosNotFoundException, Tiendanotfoundexception;
    List<ProductoDisponibleResponseDto> getProductosTotalesCentral(Integer page,Integer size)throws ProductosNotFoundException;
    List<ProductoDisponibleResponseDto> getProductosByCentral(Integer page,Integer size) throws ProductosNotFoundException;

    List<ProductoAlmacenResponseDto> getCatalogoByAlmacen(String idalmacen,Integer page,Integer size)throws AlmacenNotFoundException;

    List<ProductoInventarioByAlmacenDto> getInventarioByAlmacen(String idalmacen,Integer page,Integer size) throws AlmacenNotFoundException;

    UpdateInventoryByAlmacenRequestDto patchInventarioProductoByAlmacen(UpdateInventoryByAlmacenRequestDto producto) throws AlmacenNotFoundException, ProductosNotFoundException, InventarioNotUpdatedException;

    CreateProductoInventarioDto saveProductoInventario(String idalmacen, CreateProductoInventarioDto producto)throws AlmacenNotFoundException, ProductosNotFoundException,InventarioNotUpdatedException;

    DeleteInventarioRequestDto deleteInventario(DeleteInventarioRequestDto request)throws AlmacenNotFoundException, ProductosNotFoundException, InventarioNotUpdatedException;
}
