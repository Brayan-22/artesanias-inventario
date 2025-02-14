package com.artesanias.inventoryservice.repository;

import com.artesanias.inventoryservice.dto.projections.ProductoTiendaProjection;
import com.artesanias.inventoryservice.entity.TiendaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TiendaRepository extends JpaRepository<TiendaEntity,String> {


    @Query(value = """
    select P.id_productopk as idProducto,
    P.nombre_producto as nombre,
    P.precio_producto as precio,
    P.desc_producto as descripcion,
    P.url_imagen as urlImagen,
    P.id_categoriapk as idCategoria
    from
     tienda T join almacen A on T.id_tienda = A.id_tienda
    join inventario I on A.id_almacen = I.id_almacen
    join producto P on I.id_productopk = P.id_productopk
    where T.id_tienda = :idTienda;
    """,nativeQuery = true
    )
    List<ProductoTiendaProjection> getProductosByTienda(String idTienda);

}
