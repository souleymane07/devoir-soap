package com.groupeisi.devoirsoap.service;

import com.groupeisi.devoirsoap.dto.SectorDto;
import com.groupeisi.devoirsoap.entities.SectorEntity;
import com.groupeisi.devoirsoap.mapper.SectorMapper;
import com.groupeisi.devoirsoap.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SectorService {

    private final SectorRepository sectorRepository;

    @Autowired
    public SectorService(SectorRepository sectorRepository) {
        this.sectorRepository = sectorRepository;
    }

    @Transactional
    public Optional<SectorDto> getSectorById(Long id) {
        return sectorRepository.findById(id).map(SectorMapper::toDto);
    }

    @Transactional
    public List<SectorDto> getAllSectors() {
        return sectorRepository.findAll().stream()
                .map(SectorMapper::toDto)
                .collect(Collectors.toList());
    }

    public SectorDto saveSector(SectorDto sectorDto) {
        SectorEntity sectorEntity = new SectorEntity();
        sectorEntity.setName(sectorDto.getName());
        SectorEntity savedEntity = sectorRepository.save(sectorEntity);
        return SectorMapper.toDto(savedEntity);
    }
}