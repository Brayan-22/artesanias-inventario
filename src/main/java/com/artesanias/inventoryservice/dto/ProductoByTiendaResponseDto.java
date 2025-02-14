package com.artesanias.inventoryservice.dto;

import com.artesanias.inventoryservice.dto.projections.ProductoTiendaProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoByTiendaResponseDto {
    private String idProducto;
    private String nombre;
    private double precio;
    private String descripcion;
    private String urlImagen;
    private Integer idCategoria;

    public ProductoByTiendaResponseDto(ProductoTiendaProjection productoTiendaProjection){
        this.idProducto = productoTiendaProjection.getIdProducto();
        this.nombre = productoTiendaProjection.getNombre();
        this.precio = productoTiendaProjection.getPrecio();
        this.descripcion = productoTiendaProjection.getDescripcion();
        this.urlImagen = productoTiendaProjection.getUrlImagen();
        this.idCategoria = productoTiendaProjection.getIdCategoria();
    }
}
