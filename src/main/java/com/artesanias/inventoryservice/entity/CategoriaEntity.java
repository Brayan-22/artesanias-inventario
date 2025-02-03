package com.artesanias.inventoryservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "\"Categoria\"")
@Table(name = "\"categoria\"")
public class CategoriaEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "\"id_categoriapk\"")
    private Integer id;
    @Column(name = "\"descripcion_categoria\"")
    private String descripcion;
    @Column(name = "\"nombre_categoria\"")
    private String nombre;
}
