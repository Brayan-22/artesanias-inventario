package com.artesanias.inventoryservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "\"Producto\"")
@Table(name = "\"producto\"")
@ToString(exclude = {"inventarios"})
public class ProductoEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "\"id_productopk\"")
    private String id;
    @Column(name = "\"nombre_producto\"")
    private String nombre;
    @Column(name = "\"precio_producto\"")
    private Double precio;
    @Column(name = "\"desc_producto\"")
    private String descripcion;
    @Column(name = "\"url_imagen\"")
    private String urlImagen;
    @OneToMany(mappedBy = "producto")
    private Set<InventarioEntity> inventarios;
}
