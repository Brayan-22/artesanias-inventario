package com.artesanias.inventoryservice.dto;

public interface ProductoDisponibleProjection {
    String getProductoid();
    String getAlmacenid();
    String getSucursal();
    String getProducto();
    Long getCantidad();
}
