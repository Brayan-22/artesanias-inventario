package com.artesanias.inventoryservice.dto.projections;

public interface ProductoDisponibleProjection {
    String getProductoid();
    String getAlmacenid();
    String getSucursal();
    String getProducto();
    Long getCantidad();
}
