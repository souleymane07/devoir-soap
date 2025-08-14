package com.groupeisi.devoirsoap.mapper;

import com.groupeisi.devoirsoap.dto.SectorDto;
import com.groupeisi.devoirsoap.entities.SectorEntity;
import java.util.stream.Collectors;

public class SectorMapper {

    public static SectorDto toDto(SectorEntity sectorEntity) {
        if (sectorEntity == null) return null;
        SectorDto sectorDto = new SectorDto();
        sectorDto.setId(sectorEntity.getId());
        sectorDto.setName(sectorEntity.getName());

        // On convertit la liste de classes si elle est initialisée
        if (sectorEntity.getClasses() != null) {
            sectorDto.setClasses(sectorEntity.getClasses().stream()
                    .map(ClasseMapper::toDto)
                    .collect(Collectors.toList()));
        }

        return sectorDto;
    }
}