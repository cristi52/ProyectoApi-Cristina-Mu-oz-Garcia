package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "projects")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long proyectoId;

    @Column(name = "project_name")
    private String proyectoName;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name = "demo_url")
    private String demoUrl;

    @Column(name = "picture")
    private String picture;

    // 🔹 Relación con Status (FK en projects: status_status_id)
    @ManyToOne
    @JoinColumn(name = "status_status_id")   // coincide con tu columna en BD
    private Status status;

    // 🔹 Relación con Technology (tabla intermedia: technologies_used_in_project)
    @ManyToMany
    @JoinTable(
        name = "technologies_used_in_project",
        joinColumns = @JoinColumn(name = "project_id"),
        inverseJoinColumns = @JoinColumn(name = "tech_id")
    )
    private List<Technology> technologies;

    // 🔹 Relación con Developer (tabla intermedia: developers_worked_on_project)
    @ManyToMany
    @JoinTable(
        name = "developers_worked_on_project",
        joinColumns = @JoinColumn(name = "project_id"),
        inverseJoinColumns = @JoinColumn(name = "dev_id")
    )
    private List<Developer> developers;

    // Constructor vacío
    public Proyecto() {}

    // Getters y Setters
    public Long getProyectoId() { return proyectoId; }
    public void setProyectoId(Long proyectoId) { this.proyectoId = proyectoId; }

    public String getProyectoName() { return proyectoName; }
    public void setProyectoName(String proyectoName) { this.proyectoName = proyectoName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }

    public Date getEndDate() { return endDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }

    public String getDemoUrl() { return demoUrl; }
    public void setDemoUrl(String demoUrl) { this.demoUrl = demoUrl; }

    public String getPicture() { return picture; }
    public void setPicture(String picture) { this.picture = picture; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public List<Technology> getTechnologies() { return technologies; }
    public void setTechnologies(List<Technology> technologies) { this.technologies = technologies; }

    public List<Developer> getDevelopers() { return developers; }
    public void setDevelopers(List<Developer> developers) { this.developers = developers; }
}
