package com.artesanias.inventoryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlmacenResponseDto {
    private String idAlmacen;
    private String direccion;
    private String nombreTienda;
    private boolean isCentral;
}
