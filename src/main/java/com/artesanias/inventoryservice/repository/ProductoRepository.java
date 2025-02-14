package com.artesanias.inventoryservice.repository;

import com.artesanias.inventoryservice.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProductoRepository extends JpaRepository<ProductoEntity,String> {

    @Query(value = """
    delete from inventario
    where id_almacen in (select almacen.id_almacen from almacen join tienda on almacen.id_tienda = tienda.id_tienda where tienda.id_tienda = :idtienda)
    and id_productopk = :idproducto;
    """,nativeQuery = true)
    @Modifying
    int deleteProductoByTiendaId(String idtienda,String idproducto);
}
