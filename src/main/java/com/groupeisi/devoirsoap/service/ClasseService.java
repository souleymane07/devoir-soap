package com.groupeisi.devoirsoap.service;

import com.groupeisi.devoirsoap.dto.ClasseDto;
import com.groupeisi.devoirsoap.entities.ClasseEntity;
import com.groupeisi.devoirsoap.entities.SectorEntity;
import com.groupeisi.devoirsoap.mapper.ClasseMapper;
import com.groupeisi.devoirsoap.repository.ClasseRepository;
import com.groupeisi.devoirsoap.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClasseService {

    private final ClasseRepository classeRepository;
    private final SectorRepository sectorRepository; // Déclarez le repository pour le secteur

    @Autowired
    public ClasseService(ClasseRepository classeRepository, SectorRepository sectorRepository) {
        this.classeRepository = classeRepository;
        this.sectorRepository = sectorRepository;
    }

    public Optional<ClasseDto> getClasseById(Long id) {
        return classeRepository.findById(id).map(ClasseMapper::toDto);
    }

    public List<ClasseDto> getAllClasses() {
        return classeRepository.findAll().stream()
                .map(ClasseMapper::toDto)
                .collect(Collectors.toList());
    }

    public ClasseDto saveClasse(ClasseDto classeDto) {
        ClasseEntity classeEntity = new ClasseEntity();
        classeEntity.setClassName(classeDto.getClassName());
        classeEntity.setDescription(classeDto.getDescription());

        // C'est ici que la modification est nécessaire :
        // 1. On récupère le SectorEntity avec le sectorId du DTO
        if (classeDto.getSectorId() != null) {
            Optional<SectorEntity> sectorOptional = sectorRepository.findById(classeDto.getSectorId());
            // 2. On utilise setSector() pour lier la ClasseEntity au SectorEntity
            sectorOptional.ifPresent(classeEntity::setSector);
        }

        ClasseEntity savedEntity = classeRepository.save(classeEntity);
        return ClasseMapper.toDto(savedEntity);
    }
}