package com.artesanias.inventoryservice.services.impl;

import com.artesanias.inventoryservice.dto.*;
import com.artesanias.inventoryservice.exception.AlmacenNotFoundException;
import com.artesanias.inventoryservice.exception.InventarioNotUpdatedException;
import com.artesanias.inventoryservice.exception.ProductosNotFoundException;
import com.artesanias.inventoryservice.exception.Tiendanotfoundexception;
import com.artesanias.inventoryservice.repository.AlmacenEntityRepository;
import com.artesanias.inventoryservice.repository.InventarioRepository;
import com.artesanias.inventoryservice.repository.TiendaRepository;
import com.artesanias.inventoryservice.services.InventarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventarioServiceImpl implements InventarioService {

    private final InventarioRepository inventarioRepository;
    private final TiendaRepository tiendaRepository;
    private final AlmacenEntityRepository almacenEntityRepository;
    @Override
    public List<ProductoDisponibleResponseDto> getProductosTodasSedes(Integer page, Integer size) throws ProductosNotFoundException {
        if (Objects.isNull(page) || Objects.isNull(size)) throw new ProductosNotFoundException("No se encontraron productos");
        if (page < 0 || size < 0) throw new ProductosNotFoundException("No se encontraron productos");
        Pageable pageable = PageRequest.of(page, size);
        return inventarioRepository.findProductosTodasSedes(pageable).map(ProductoDisponibleResponseDto::new).toList();
    }

    @Override
    public List<ProductoDisponibleResponseDto> getProductosBySede(Integer page, Integer size, String idSede) throws ProductosNotFoundException, Tiendanotfoundexception {
        if (Objects.isNull(page) || Objects.isNull(size)) throw new ProductosNotFoundException("No se encontraron productos");
        if (page < 0 || size < 0) throw new ProductosNotFoundException("No se encontraron productos");
        tiendaRepository.findById(idSede).orElseThrow(() -> new Tiendanotfoundexception("No se encontró la sede"));
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

    @Override
    public List<ProductoAlmacenResponseDto> getCatalogoByAlmacen(String idalmacen,Integer page,Integer size)throws AlmacenNotFoundException {
        if (almacenEntityRepository.findById(idalmacen).isEmpty()) throw new AlmacenNotFoundException("No se encontró el almacén");
        Pageable pageable = null;
        if (Objects.nonNull(page) && Objects.nonNull(size)) {
            pageable = PageRequest.of(page, size);
        }else {
            pageable = PageRequest.of(0, 10);
        }
        return inventarioRepository.findProductosByAlmacen_Id(idalmacen,pageable).map(ProductoAlmacenResponseDto::new).toList();
    }

    @Override
    public List<ProductoInventarioByAlmacenDto> getInventarioByAlmacen(String idalmacen, Integer page, Integer size)throws AlmacenNotFoundException {
        if (almacenEntityRepository.findById(idalmacen).isEmpty()) throw new AlmacenNotFoundException("No se encontró el almacén");
        Pageable pageable = null;
        if (Objects.nonNull(page) && Objects.nonNull(size)) {
            pageable = PageRequest.of(page, size);
        }else {
            pageable = PageRequest.of(0, 10);
        }
        return inventarioRepository.findInventarioByAlmacenId(idalmacen,pageable).map(ProductoInventarioByAlmacenDto::new).toList();
    }

    @Transactional
    @Override
    public UpdateInventoryByAlmacenRequestDto patchInventarioProductoByAlmacen(UpdateInventoryByAlmacenRequestDto producto) throws InventarioNotUpdatedException {
        if (Objects.isNull(producto)) throw new InventarioNotUpdatedException("El json no puede ser nulo");
        if (inventarioRepository.existsInventarioByAlmacenIdAndProductoId(producto.getIdAlmacen(), producto.getIdProducto())==0)
            throw new InventarioNotUpdatedException("No se encontraron inventarios con la solicitud");
        if (producto.getCantidad() < 0) throw new InventarioNotUpdatedException("Cantidad no permitida");
        int updated = inventarioRepository.updateInventarioByAlmacen(producto.getIdAlmacen(), producto.getIdProducto(), producto.getCantidad());
        if (updated == 0) throw new InventarioNotUpdatedException("No se pudo actualizar el inventario");
        return producto;
    }

    @Transactional
    @Override
    public CreateProductoInventarioDto saveProductoInventario(String idalmacen, CreateProductoInventarioDto producto) throws AlmacenNotFoundException, ProductosNotFoundException, InventarioNotUpdatedException {
        if (Objects.isNull(idalmacen) || idalmacen.isEmpty()) throw new AlmacenNotFoundException("No se encontró el almacén");
        if (Objects.isNull(producto)) throw new ProductosNotFoundException("No se encontró el producto");
        if (producto.getCantidad() < 0) throw new InventarioNotUpdatedException("Cantidad no permitida");
        if (Objects.isNull(producto.getIdProducto()) || producto.getIdProducto().isEmpty()) throw new ProductosNotFoundException("No se encontró el producto");
        if (Objects.isNull(producto.getIdAlmacen()) || producto.getIdAlmacen().isEmpty()) throw new AlmacenNotFoundException("No se encontró el almacen");
        if (inventarioRepository.existsInventarioByAlmacenIdAndProductoId(producto.getIdAlmacen(), producto.getIdProducto())>0)
            throw new InventarioNotUpdatedException("Ya existe un inventario con la solicitud");
        inventarioRepository.saveProductoInventario(idalmacen, producto.getIdProducto(), producto.getCantidad());
        return producto;
    }

    @Transactional
    @Override
    public DeleteInventarioRequestDto deleteInventario(DeleteInventarioRequestDto request) throws AlmacenNotFoundException, ProductosNotFoundException, InventarioNotUpdatedException {
        if (Objects.isNull(request)) throw new InventarioNotUpdatedException("El json no puede ser nulo");
        if (Objects.isNull(request.getIdAlmacen()) || request.getIdAlmacen().isEmpty()) throw new AlmacenNotFoundException("No se encontró el almacén");
        if (Objects.isNull(request.getIdProducto()) || request.getIdProducto().isEmpty()) throw new ProductosNotFoundException("No se encontró el producto");
        if (inventarioRepository.existsInventarioByAlmacenIdAndProductoId(request.getIdAlmacen(), request.getIdProducto())==0)
            throw new InventarioNotUpdatedException("No se encontraron inventarios con la solicitud");
        inventarioRepository.deleteInventario(request.getIdAlmacen(), request.getIdProducto());
        return request;
    }
}