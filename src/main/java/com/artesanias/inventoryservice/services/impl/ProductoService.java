package com.artesanias.inventoryservice.services.impl;

import com.artesanias.inventoryservice.dto.CreateProductoRequestDto;
import com.artesanias.inventoryservice.dto.CreateProductoResponseDto;
import com.artesanias.inventoryservice.entity.CategoriaEntity;
import com.artesanias.inventoryservice.entity.ProductoEntity;
import com.artesanias.inventoryservice.exception.ProductoNotCreatedException;
import com.artesanias.inventoryservice.exception.ProductosNotFoundException;
import com.artesanias.inventoryservice.repository.CategoriaRepository;
import com.artesanias.inventoryservice.repository.ProductoRepository;
import com.artesanias.inventoryservice.services.IProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductoService implements IProductoService {
    private final CategoriaRepository categoriaRepository;
    private final ProductoRepository productoRepository;
    @Transactional
    @Override
    public CreateProductoResponseDto createProducto(CreateProductoRequestDto request) throws ProductoNotCreatedException {
        if (request == null) throw new ProductoNotCreatedException("Producto no creado");
        if (request.getNombre().isEmpty() || request.getDescripcion().isEmpty() || request.getPrecio() == 0 || request.getIdCategoria() == 0 || request.getUrlImagen().isEmpty())
            throw new ProductoNotCreatedException("Producto no creado");
        CategoriaEntity categoriaEntity = categoriaRepository.findById(request.getIdCategoria()).orElseThrow(() -> new ProductoNotCreatedException("Producto no creado"));
        ProductoEntity productoEntity = new ProductoEntity();
        productoEntity.setNombre(request.getNombre());
        productoEntity.setDescripcion(request.getDescripcion());
        productoEntity.setPrecio(request.getPrecio());
        productoEntity.setCategoria(categoriaEntity);
        productoEntity.setUrlImagen(request.getUrlImagen());
        ProductoEntity result = productoRepository.save(productoEntity);
        return new CreateProductoResponseDto(
                result.getId(),
                request.getIdCategoria(),
                result.getNombre(),
                result.getPrecio(),
                result.getDescripcion(),
                result.getUrlImagen()
        );

    }

    @Transactional
    @Override
    public CreateProductoResponseDto updateProducto(String idProducto,CreateProductoRequestDto request) throws ProductoNotCreatedException, ProductosNotFoundException {
        if (request == null) throw new ProductoNotCreatedException("Producto no actualizado");
        if (request.getNombre().isEmpty() || request.getDescripcion().isEmpty() || request.getPrecio() == 0 || request.getIdCategoria() == 0 || request.getUrlImagen().isEmpty())
            throw new ProductoNotCreatedException("Producto no actualizado");
        ProductoEntity productoEntity = productoRepository.findById(idProducto).orElseThrow(() -> new ProductosNotFoundException("Producto no encontrado"));
        CategoriaEntity categoriaEntity = categoriaRepository.findById(request.getIdCategoria()).orElseThrow(() -> new ProductoNotCreatedException("Categoria no encontrada"));
        productoEntity.setUrlImagen(request.getUrlImagen());
        productoEntity.setCategoria(categoriaEntity);
        productoEntity.setDescripcion(request.getDescripcion());
        productoEntity.setNombre(request.getNombre());
        productoEntity.setPrecio(request.getPrecio());
        ProductoEntity result = productoRepository.save(productoEntity);
        return new CreateProductoResponseDto(
                result.getId(),
                request.getIdCategoria(),
                result.getNombre(),
                result.getPrecio(),
                result.getDescripcion(),
                result.getUrlImagen()
        );
    }
}
