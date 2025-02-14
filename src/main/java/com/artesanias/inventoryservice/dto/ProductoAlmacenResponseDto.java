package com.artesanias.inventoryservice.dto;

import com.artesanias.inventoryservice.dto.projections.ProductoAlmacenProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoAlmacenResponseDto {
    private String id;
    private String nombre;
    private Double precio;
    private String descripcion;
    private String urlImagen;
    private String id_categoria;

    public ProductoAlmacenResponseDto(ProductoAlmacenProjection productoAlmacenProjection){
        this.id = productoAlmacenProjection.getId();
        this.nombre = productoAlmacenProjection.getNombre();
        this.precio = productoAlmacenProjection.getPrecio();
        this.descripcion = productoAlmacenProjection.getDescripcion();
        this.urlImagen = productoAlmacenProjection.getUrlImagen();
        this.id_categoria = productoAlmacenProjection.getId_categoria();
    }
}
