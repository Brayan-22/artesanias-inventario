package com.artesanias.inventoryservice.services.impl;

import com.artesanias.inventoryservice.dto.*;
import com.artesanias.inventoryservice.entity.AlmacenEntity;
import com.artesanias.inventoryservice.entity.CategoriaEntity;
import com.artesanias.inventoryservice.entity.ProductoEntity;
import com.artesanias.inventoryservice.entity.TiendaEntity;
import com.artesanias.inventoryservice.exception.ProductoNotCreatedException;
import com.artesanias.inventoryservice.exception.ProductosNotFoundException;
import com.artesanias.inventoryservice.exception.Tiendanotfoundexception;
import com.artesanias.inventoryservice.repository.*;
import com.artesanias.inventoryservice.services.ITiendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TiendaServiceImpl implements ITiendaService {

    private final TiendaRepository tiendaRepository;
    private final AlmacenEntityRepository almacenEntityRepository;
    private final InventarioRepository inventarioRepository;
    private final CategoriaRepository categoriaRepository;
    private final ProductoRepository productoRepository;

    @Transactional
    @Override
    public List<TiendaResponseDto> getTiendas() throws Tiendanotfoundexception {
        List<TiendaResponseDto> tiendas = tiendaRepository.findAll().stream()
                .map(t -> new TiendaResponseDto(t.getId(), t.getNombre(), t.getUbicacion().getDireccion()))
                .toList();
        if (tiendas.isEmpty()) throw new Tiendanotfoundexception("Tiendas no encontradas");
        return tiendas;
    }

    @Override
    public List<ProductoByTiendaResponseDto> getProductosByTienda(String idTienda) throws Tiendanotfoundexception, ProductosNotFoundException {
        tiendaRepository.findById(idTienda).orElseThrow(() -> new Tiendanotfoundexception("Tienda no encontrada"));
        List<ProductoByTiendaResponseDto> productos = tiendaRepository.getProductosByTienda(idTienda).stream()
                .map(p -> new ProductoByTiendaResponseDto(p.getIdProducto(), p.getNombre(), p.getPrecio(), p.getDescripcion(), p.getUrlImagen(), p.getIdCategoria()))
                .toList();
        if (productos.isEmpty()) throw new ProductosNotFoundException("Productos no encontrados");
        return productos;
    }

    @Transactional
    @Override
    public DeleteProductoByTiendaResponseDto deleteProductoByTienda(String idTienda, DeleteProductoByTiendaRequestDto requestDto) throws Tiendanotfoundexception, ProductosNotFoundException {
        if (!tiendaRepository.existsById(idTienda)) throw new Tiendanotfoundexception("Tienda no encontrada");
        if (!productoRepository.existsById(requestDto.getIdProducto())) throw new ProductosNotFoundException("Producto no encontrado");
        int res = productoRepository.deleteProductoByTiendaId(idTienda, requestDto.getIdProducto());
        if (res == 0) throw new ProductosNotFoundException("Producto no encontrado");
        return new DeleteProductoByTiendaResponseDto(requestDto.getIdProducto(), idTienda);
    }


}
