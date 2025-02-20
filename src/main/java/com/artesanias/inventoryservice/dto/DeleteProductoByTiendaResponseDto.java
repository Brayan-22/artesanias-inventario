package com.artesanias.inventoryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteProductoByTiendaResponseDto {
    private String idProducto;
    private String idTienda;
}
