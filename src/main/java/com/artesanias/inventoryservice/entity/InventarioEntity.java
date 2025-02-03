package com.artesanias.inventoryservice.entity;


import com.artesanias.inventoryservice.dto.ProductoDisponibleResponseDto;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "\"inventario\"")
@ToString
public class InventarioEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private InventarioId id;

    @ManyToOne
    @MapsId("idProducto")
    @JoinColumn(name = "\"id_productopk\"")
    private ProductoEntity producto;

    @ManyToOne
    @MapsId("idAlmacen")
    @JoinColumn(name = "\"id_almacen\"")
    private AlmacenEntity almacen;

    @Column(name = "\"cantidad\"")
    private Integer cantidad;
}
