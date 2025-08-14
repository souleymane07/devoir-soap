package com.groupeisi.devoirsoap.repository;

import com.groupeisi.devoirsoap.entities.SectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectorRepository extends JpaRepository<SectorEntity, Long> {
}