package com.artesanias.inventoryservice.repository;

import com.artesanias.inventoryservice.entity.TiendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TiendaRepository extends JpaRepository<TiendaEntity,String> {
    Optional<TiendaEntity> findById(String id);
}
