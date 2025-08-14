package com.groupeisi.devoirsoap.repository;

import com.groupeisi.devoirsoap.entities.ClasseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasseRepository extends JpaRepository<ClasseEntity, Long> {
}