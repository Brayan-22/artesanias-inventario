package com.artesanias.inventoryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateProductoInventarioDto {
    private String idProducto;
    private String idAlmacen;
    private Long cantidad;
}
