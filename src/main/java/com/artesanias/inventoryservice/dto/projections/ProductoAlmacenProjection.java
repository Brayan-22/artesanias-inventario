package com.artesanias.inventoryservice.dto.projections;

public interface ProductoAlmacenProjection {
    String getId();
    String getNombre();
    Double getPrecio();
    String getDescripcion();
    String getUrlImagen();
    String getId_categoria();
}
