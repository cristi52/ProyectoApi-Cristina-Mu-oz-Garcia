package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "technologies")
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tech_id")
    private Long techId;

    @Column(name = "tech_name")
    private String techName;

    @ManyToMany(mappedBy = "technologies")
    private List<Proyecto> projects;

    public Technology() {}

    public Technology(String techName) {
        this.techName = techName;
    }

    // Getters y Setters
    public Long getTechId() { return techId; }
    public void setTechId(Long techId) { this.techId = techId; }

    public String getTechName() { return techName; }
    public void setTechName(String techName) { this.techName = techName; }
}
