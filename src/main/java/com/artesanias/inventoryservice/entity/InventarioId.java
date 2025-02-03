package com.artesanias.inventoryservice.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InventarioId implements Serializable {
    private String idProducto;
    private String idAlmacen;
}
