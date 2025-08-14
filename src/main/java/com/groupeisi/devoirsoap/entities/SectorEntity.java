package com.groupeisi.devoirsoap.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sector_entity")
public class SectorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // Relation bidirectionnelle
    @OneToMany(mappedBy = "sector", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ClasseEntity> classes;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<ClasseEntity> getClasses() { return classes; }
    public void setClasses(List<ClasseEntity> classes) { this.classes = classes; }
}