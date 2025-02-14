package com.artesanias.inventoryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeleteInventarioRequestDto {
    private String idProducto;
    private String idAlmacen;
}
