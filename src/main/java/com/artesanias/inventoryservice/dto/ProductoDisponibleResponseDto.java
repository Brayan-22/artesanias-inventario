package com.artesanias.inventoryservice.dto;

import com.artesanias.inventoryservice.dto.projections.ProductoDisponibleProjection;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class ProductoDisponibleResponseDto {
    private String idProducto;
    private String idAlmacen;
    private String sucursal;
    private String producto;
    private Long cantidad;

    public ProductoDisponibleResponseDto(String idProducto, String idAlmacen, String sucursal, String producto, Long cantidad) {
        this.idProducto = idProducto;
        this.idAlmacen = idAlmacen;
        this.sucursal = sucursal;
        this.producto = producto;
        this.cantidad = cantidad;
    }
    public ProductoDisponibleResponseDto(ProductoDisponibleProjection productoDisponibleProjection){
        this.idProducto = productoDisponibleProjection.getProductoid();
        this.idAlmacen = productoDisponibleProjection.getAlmacenid();
        this.sucursal = productoDisponibleProjection.getSucursal();
        this.producto = productoDisponibleProjection.getProducto();
        this.cantidad = productoDisponibleProjection.getCantidad();
    }
}
