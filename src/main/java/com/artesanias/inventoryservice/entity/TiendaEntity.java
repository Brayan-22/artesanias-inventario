package com.artesanias.inventoryservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "\"Tienda\"")
@Table(name = "\"tienda\"")
@ToString(exclude = "almacenes")
public class TiendaEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "\"id_tienda\"")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "\"nombre_tienda\"")
    private String nombre;
    @OneToMany(mappedBy = "tienda")
    private Set<AlmacenEntity> almacenes;
}
