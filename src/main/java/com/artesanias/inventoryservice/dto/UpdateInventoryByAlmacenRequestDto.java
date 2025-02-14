package com.artesanias.inventoryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateInventoryByAlmacenRequestDto {
    private String idAlmacen;
    private String idProducto;
    private Long cantidad;
}
