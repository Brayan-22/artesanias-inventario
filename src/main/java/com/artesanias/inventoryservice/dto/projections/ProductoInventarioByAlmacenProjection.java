package com.artesanias.inventoryservice.dto.projections;

public interface ProductoInventarioByAlmacenProjection {
    String getIdProducto();
    String getIdAlmacen();
    String getDireccion();
    String getProducto();
    String getCantidad();
}
