package com.groupeisi.devoirsoap.dto;

import java.util.List;

public class SectorDto {
    private Long id;
    private String name;
    private List<ClasseDto> classes;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<ClasseDto> getClasses() { return classes; }
    public void setClasses(List<ClasseDto> classes) { this.classes = classes; }
}