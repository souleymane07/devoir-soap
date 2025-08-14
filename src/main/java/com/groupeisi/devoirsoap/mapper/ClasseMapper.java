package com.groupeisi.devoirsoap.mapper;

import com.groupeisi.devoirsoap.dto.ClasseDto;
import com.groupeisi.devoirsoap.entities.ClasseEntity;

public class ClasseMapper {

    public static ClasseDto toDto(ClasseEntity classeEntity) {
        if (classeEntity == null) return null;
        ClasseDto classeDto = new ClasseDto();
        classeDto.setId(classeEntity.getId());
        classeDto.setClassName(classeEntity.getClassName());
        classeDto.setDescription(classeEntity.getDescription());
        return classeDto;
    }
}