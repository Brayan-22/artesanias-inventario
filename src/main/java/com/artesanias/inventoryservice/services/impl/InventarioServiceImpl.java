package com.artesanias.inventoryservice.services.impl;

import com.artesanias.inventoryservice.dto.ProductoDisponibleResponseDto;
import com.artesanias.inventoryservice.exception.ProductosNotFoundException;
import com.artesanias.inventoryservice.exception.SedeNotFoundException;
import com.artesanias.inventoryservice.repository.InventarioRepository;
import com.artesanias.inventoryservice.repository.TiendaRepository;
import com.artesanias.inventoryservice.services.InventarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventarioServiceImpl implements InventarioService {

    private final InventarioRepository inventarioRepository;
    private final TiendaRepository tiendaRepository;
    @Override
    public List<ProductoDisponibleResponseDto> getProductosTodasSedes(Integer page, Integer size) throws ProductosNotFoundException {
        if (Objects.isNull(page) || Objects.isNull(size)) throw new ProductosNotFoundException("No se encontraron productos");
        if (page < 0 || size < 0) throw new ProductosNotFoundException("No se encontraron productos");
        Pageable pageable = PageRequest.of(page, size);
        return inventarioRepository.findProductosTodasSedes(pageable).map(ProductoDisponibleResponseDto::new).toList();
    }

    @Override
    public List<ProductoDisponibleResponseDto> getProductosBySede(Integer page, Integer size, String idSede) throws ProductosNotFoundException, SedeNotFoundException {
        if (Objects.isNull(page) || Objects.isNull(size)) throw new ProductosNotFoundException("No se encontraron productos");
        if (page < 0 || size < 0) throw new ProductosNotFoundException("No se encontraron productos");
        tiendaRepository.findById(idSede).orElseThrow(() -> new SedeNotFoundException("No se encontró la sede"));
        Pageable pageable = PageRequest.of(page, size);
        return inventarioRepository.findProductosBySede(pageable, idSede).map(ProductoDisponibleResponseDto::new).toList();
    }

    @Override
    public List<ProductoDisponibleResponseDto> getProductosTotalesCentral(Integer page, Integer size) throws ProductosNotFoundException {
        if (Objects.isNull(page) || Objects.isNull(size)) throw new ProductosNotFoundException("No se encontraron productos");
        if (page < 0 || size < 0) throw new ProductosNotFoundException("No se encontraron productos");
        Pageable pageable = PageRequest.of(page, size);
        return inventarioRepository.findProductosTotalesCentral(pageable).map(ProductoDisponibleResponseDto::new).toList();
    }

    @Override
    public List<ProductoDisponibleResponseDto> getProductosByCentral(Integer page, Integer size) throws ProductosNotFoundException {
        if (Objects.isNull(page) || Objects.isNull(size)) throw new ProductosNotFoundException("No se encontraron productos");
        if (page < 0 || size < 0) throw new ProductosNotFoundException("No se encontraron productos");
        Pageable pageable = PageRequest.of(page, size);
        return inventarioRepository.findProductosByCentral(pageable).map(ProductoDisponibleResponseDto::new).toList();
    }
}
