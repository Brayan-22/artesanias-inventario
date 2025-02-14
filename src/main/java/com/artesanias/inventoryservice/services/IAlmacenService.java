package com.artesanias.inventoryservice.services;

import com.artesanias.inventoryservice.dto.AlmacenResponseDto;
import com.artesanias.inventoryservice.dto.UpdateAlmacenDto;
import com.artesanias.inventoryservice.exception.AlmacenNotFoundException;

import java.util.List;

public interface IAlmacenService {
    List<AlmacenResponseDto> getAlmacenByTienda(String idTienda)throws AlmacenNotFoundException;

    AlmacenResponseDto getAlmacenById(String idAlmacen);

    AlmacenResponseDto updateAlmacen(String idAlmacen, UpdateAlmacenDto almacen) throws AlmacenNotFoundException;
}
