package com.artesanias.inventoryservice.services.impl;

import com.artesanias.inventoryservice.dto.ProductoResponseDto;
import com.artesanias.inventoryservice.dto.TiendaResponseDto;
import com.artesanias.inventoryservice.entity.AlmacenEntity;
import com.artesanias.inventoryservice.entity.TiendaEntity;
import com.artesanias.inventoryservice.exception.ProductosNotFoundException;
import com.artesanias.inventoryservice.exception.tiendanotfoundexception;
import com.artesanias.inventoryservice.repository.AlmacenEntityRepository;
import com.artesanias.inventoryservice.repository.InventarioRepository;
import com.artesanias.inventoryservice.repository.TiendaRepository;
import com.artesanias.inventoryservice.services.ITiendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TiendaServiceImpl implements ITiendaService {

    private final TiendaRepository tiendaRepository;
    private final AlmacenEntityRepository almacenEntityRepository;
    private final InventarioRepository inventarioRepository;
    @Transactional
    @Override
    public List<TiendaResponseDto> getTiendas() throws tiendanotfoundexception {
        List<TiendaResponseDto> tiendas = tiendaRepository.findAll().stream()
                .map(t -> new TiendaResponseDto(t.getId(), t.getNombre(), t.getUbicacion().getDireccion()))
                .toList();
        if (tiendas.isEmpty()) throw new tiendanotfoundexception("Tiendas no encontradas");
        return tiendas;
    }

    @Override
    public List<ProductoResponseDto> getProductosByTienda(String idTienda) throws tiendanotfoundexception, ProductosNotFoundException {
        TiendaEntity tienda = tiendaRepository.findById(idTienda).orElseThrow(() -> new tiendanotfoundexception("Tienda no encontrada"));
        List<AlmacenEntity> almacenesTienda = almacenEntityRepository.findByTienda_Id(idTienda);
        if (almacenesTienda.isEmpty()) throw new ProductosNotFoundException("Productos no encontrados");
        return null;
    }
}
