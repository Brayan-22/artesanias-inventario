package com.artesanias.inventoryservice.repository;

import com.artesanias.inventoryservice.entity.AlmacenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlmacenEntityRepository extends JpaRepository<AlmacenEntity, String> {

  List<AlmacenEntity> findByTienda_Id(String tiendaId);

  String id(String id);
}