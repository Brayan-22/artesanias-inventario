package com.artesanias.inventoryservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductoRequestDto {
    private Integer idCategoria;
    private String nombre;
    private Double precio;
    private String descripcion;
    private String urlImagen;
}
