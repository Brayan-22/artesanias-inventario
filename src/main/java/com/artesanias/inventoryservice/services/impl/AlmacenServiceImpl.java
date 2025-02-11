package com.artesanias.inventoryservice.services.impl;

import com.artesanias.inventoryservice.dto.AlmacenResponseDto;
import com.artesanias.inventoryservice.entity.AlmacenEntity;
import com.artesanias.inventoryservice.exception.AlmacenNotFoundException;
import com.artesanias.inventoryservice.repository.AlmacenEntityRepository;
import com.artesanias.inventoryservice.services.IAlmacenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlmacenServiceImpl implements IAlmacenService {

    private final AlmacenEntityRepository almacenEntityRepository;

    @Transactional(readOnly = true)
    @Override
    public List<AlmacenResponseDto> getAlmacenByTienda(String idTienda)throws AlmacenNotFoundException {
        List<AlmacenResponseDto> almacenResponseDtos = almacenEntityRepository.findByTienda_Id(idTienda).stream()
                .map(a -> new AlmacenResponseDto(a.getId(), a.getUbicacion().getDireccion(), a.getTienda().getNombre(),a.getIsCentral()))
                .toList();
        if (almacenResponseDtos.isEmpty()) throw new AlmacenNotFoundException("Almacenes no encontrados");
        return almacenResponseDtos;
    }

    @Override
    public AlmacenResponseDto getAlmacenById(String idAlmacen) {
        AlmacenEntity almacenEntity = almacenEntityRepository.findById(idAlmacen).orElseThrow(() -> new AlmacenNotFoundException("Almacen no encontrado"));
        return new AlmacenResponseDto(almacenEntity.getId(), almacenEntity.getUbicacion().getDireccion(), almacenEntity.getTienda().getNombre(),almacenEntity.getIsCentral());
    }
}
