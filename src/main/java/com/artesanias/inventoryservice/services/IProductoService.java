package com.artesanias.inventoryservice.services;

import com.artesanias.inventoryservice.dto.CreateProductoRequestDto;
import com.artesanias.inventoryservice.dto.CreateProductoResponseDto;
import com.artesanias.inventoryservice.exception.ProductoNotCreatedException;
import com.artesanias.inventoryservice.exception.ProductosNotFoundException;

public interface IProductoService {

    CreateProductoResponseDto createProducto(CreateProductoRequestDto request) throws ProductoNotCreatedException;

    CreateProductoResponseDto updateProducto(String idproducto,CreateProductoRequestDto request) throws ProductoNotCreatedException, ProductosNotFoundException;
}
