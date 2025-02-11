package com.artesanias.inventoryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoResponseDto {
    private String idProducto;
    private String idTienda;
    private String nombreProducto;
    private Double precio;
    private String descripcion;
    private String nombreCategoria;
}
