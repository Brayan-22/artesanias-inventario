package com.artesanias.inventoryservice.repository;

import com.artesanias.inventoryservice.dto.projections.ProductoAlmacenProjection;
import com.artesanias.inventoryservice.dto.projections.ProductoDisponibleProjection;
import com.artesanias.inventoryservice.dto.projections.ProductoInventarioByAlmacenProjection;
import com.artesanias.inventoryservice.entity.InventarioEntity;
import com.artesanias.inventoryservice.entity.InventarioId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface InventarioRepository extends JpaRepository<InventarioEntity, InventarioId> {

    @Query(value = """
    SELECT I.id_productopk productoid,A.id_almacen almacenid,
    COALESCE(T.nombre_tienda, 'central') AS sucursal, P.nombre_producto producto, I.cantidad as cantidad
    FROM producto P
    JOIN inventario I ON P.id_productopk = I.id_productopk
    JOIN almacen A ON I.id_almacen = A.id_almacen
    LEFT JOIN tienda T ON A.id_tienda = T.id_tienda;
    """ ,
            countQuery = """
    SELECT count(*)
    FROM producto P
    JOIN inventario I ON P.id_productopk = I.id_productopk
    JOIN almacen A ON I.id_almacen = A.id_almacen
    LEFT JOIN tienda T ON A.id_tienda = T.id_tienda;
    """
            ,nativeQuery = true)
    Page<ProductoDisponibleProjection> findProductosTodasSedes(Pageable pageable);

    @Query(value = """
    SELECT I.id_productopk productoid,A.id_almacen almacenid,
    T.nombre_tienda AS sucursal, P.nombre_producto producto, I.cantidad as cantidad
    from  producto P join
    inventario I on P.id_productopk = I.id_productopk
    join almacen A
    on I.id_almacen = A.id_almacen
    join tienda T
    on A.id_tienda = T.id_tienda
    where T.id_tienda= :idTienda;
        """,
    countQuery = """
    SELECT count(*)
    from  producto P join
    inventario I on P.id_productopk = I.id_productopk
    join almacen A
    on I.id_almacen = A.id_almacen
    join tienda T
    on A.id_tienda = T.id_tienda
    where T.id_tienda= :idTienda;
    """,
    nativeQuery = true)
    Page<ProductoDisponibleProjection> findProductosBySede(Pageable pageable, String idTienda);

    @Query(value = """
        select P.id_productopk as productoid,'central' as almacenid,
        'central' as sucursal,P.nombre_producto producto
        ,principal.cantidad as cantidad
        from (select P.id_productopk idP, sum(I.cantidad) cantidad
        from producto P
        join
        inventario I on P.id_productopk = I.id_productopk
        join almacen A
        on I.id_almacen = A.id_almacen
        where is_central = true
        group by P.id_productopk) as principal
        join producto P on principal.idP = P.id_productopk;
        """,
        countQuery = """
        select count(*)
        from (select P.id_productopk idP, sum(I.cantidad) cantidad
        from producto P
        join
        inventario I on P.id_productopk = I.id_productopk
        join almacen A
        on I.id_almacen = A.id_almacen
        where is_central = true
        group by P.id_productopk) as principal
        join producto P on principal.idP = P.id_productopk;
        """
            ,nativeQuery = true)
    Page<ProductoDisponibleProjection> findProductosTotalesCentral(Pageable pageable);

    @Query(value = """
        select P.id_productopk productoid,
        A.id_almacen almacenid,
        'central' as sucursal,
        P.nombre_producto producto,
        I.cantidad as cantidad
        from producto P
        join
        inventario I on P.id_productopk = I.id_productopk
        join almacen A
        on I.id_almacen = A.id_almacen
        where is_central = true
        order by A.id_almacen,P.id_productopk;
        """,
        countQuery = """
        select count(*)
        from producto P
                 join
             inventario I on P.id_productopk = I.id_productopk
                 join almacen A
                      on I.id_almacen = A.id_almacen
        where is_central = true
        group by A.id_almacen,P.id_productopk
        order by A.id_almacen,P.id_productopk;
"""
            ,nativeQuery = true)
    Page<ProductoDisponibleProjection> findProductosByCentral(Pageable pageable);

    @Query(
            value = """
    select P.id_productopk as id,
           P.nombre_producto as nombre,
           P.precio_producto as precio,
           P.desc_producto as descripcion,
           P.url_imagen as urlImagen,
           P.id_categoriapk as id_categoria
        from inventario I
    join almacen A on I.id_almacen = A.id_almacen
    join producto P on I.id_productopk = P.id_productopk
    where A.id_almacen = :almacenId;
    """,nativeQuery = true
    )
    Page<ProductoAlmacenProjection> findProductosByAlmacen_Id(String almacenId, Pageable pageable);

    @Query(
            value = """
            select P.id_productopk as idProducto,
            A.id_almacen as idAlmacen,
            U.direccion as direccion,
            P.nombre_producto as producto,
            I.cantidad as cantidad
            from
            inventario I
            join almacen A on I.id_almacen = A.id_almacen
            join producto P on I.id_productopk = P.id_productopk
            join ubicacion U on A.id_ubicacion = U.id_ubicacion
            where A.id_almacen = :almacenId;
    """, nativeQuery = true)
    Page<ProductoInventarioByAlmacenProjection> findInventarioByAlmacenId(String almacenId,Pageable pageable);



    boolean existsInventarioEntityByAlmacen_IdAndProducto_Id(String almacenId, String productoId);
    @Query(value = """
    update inventario set cantidad = :cantidad
    where id_almacen = :idAlmacen and id_productopk = :idProducto;
    """,nativeQuery = true)
    @Modifying(clearAutomatically = true)
    int updateInventarioByAlmacen(String idAlmacen, String idProducto, Long cantidad);
}
