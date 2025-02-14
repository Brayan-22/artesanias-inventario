package com.artesanias.inventoryservice.dto.projections;

public interface ProductoTiendaProjection {
    String getIdProducto();
    String getNombre();
    Double getPrecio();
    String getDescripcion();
    String getUrlImagen();
    Integer getIdCategoria();
}
