package com.groupeisi.devoirsoap.entities;

import javax.persistence.*;

@Entity
@Table(name = "classe_entity")
public class ClasseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String className;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sector_id")
    private SectorEntity sector;

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public SectorEntity getSector() { return sector; }
    public void setSector(SectorEntity sector) { this.sector = sector; }
}