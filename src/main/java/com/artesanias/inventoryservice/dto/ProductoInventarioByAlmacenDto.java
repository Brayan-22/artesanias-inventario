package com.artesanias.inventoryservice.dto;

import com.artesanias.inventoryservice.dto.projections.ProductoInventarioByAlmacenProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoInventarioByAlmacenDto {
    private String idProducto;
    private String idAlmacen;
    private String direccion;
    private String producto;
    private String cantidad;

    public ProductoInventarioByAlmacenDto(ProductoInventarioByAlmacenProjection productoInventarioByAlmacenProjection){
        this.idProducto = productoInventarioByAlmacenProjection.getIdProducto();
        this.idAlmacen = productoInventarioByAlmacenProjection.getIdAlmacen();
        this.direccion = productoInventarioByAlmacenProjection.getDireccion();
        this.producto = productoInventarioByAlmacenProjection.getProducto();
        this.cantidad = productoInventarioByAlmacenProjection.getCantidad();
    }
}

