package com.artesanias.inventoryservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ubicacion")
public class Ubicacion {
    @Id
    @Column(name = "id_ubicacion", nullable = false)
    private Integer id;

    @Size(max = 64)
    @NotNull
    @Column(name = "direccion", nullable = false, length = 64)
    private String direccion;

}