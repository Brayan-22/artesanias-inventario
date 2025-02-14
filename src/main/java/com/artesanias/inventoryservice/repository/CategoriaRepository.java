package com.artesanias.inventoryservice.repository;

import com.artesanias.inventoryservice.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity,Integer> {
}
