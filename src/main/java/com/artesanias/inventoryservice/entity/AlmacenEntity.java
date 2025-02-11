package com.artesanias.inventoryservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "\"Almacen\"")
@Table(name = "\"almacen\"")
@ToString(exclude = {"inventarios", "tienda"})
public class AlmacenEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "\"id_almacen\"")
    private String id;
    @Column(name = "\"is_central\"")
    private Boolean isCentral;
    @OneToMany(mappedBy = "almacen")
    private Set<InventarioEntity> inventarios;
    @ManyToOne
    @JoinColumn(name = "\"id_tienda\"")
    private TiendaEntity tienda;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "\"id_ubicacion\"")
    private Ubicacion ubicacion;

}