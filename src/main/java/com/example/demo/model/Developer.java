package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "developers")
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dev_id")
    private Long devId;

    @Column(name = "dev_name")
    private String devName;

    @Column(name = "dev_surname")
    private String devSurname;

    @Column(name = "email")
    private String email;

    @Column(name = "linkedin_url")
    private String linkedinUrl;

    @Column(name = "github_url")
    private String githubUrl;

    @ManyToMany(mappedBy = "developers")
    private List<Proyecto> projects;

    public Developer() {}

    public Developer(String devName, String devSurname, String email) {
        this.devName = devName;
        this.devSurname = devSurname;
        this.email = email;
    }

    // Getters y Setters
    public Long getDevId() { return devId; }
    public void setDevId(Long devId) { this.devId = devId; }

    public String getDevName() { return devName; }
    public void setDevName(String devName) { this.devName = devName; }

    public String getDevSurname() { return devSurname; }
    public void setDevSurname(String devSurname) { this.devSurname = devSurname; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getLinkedinUrl() { return linkedinUrl; }
    public void setLinkedinUrl(String linkedinUrl) { this.linkedinUrl = linkedinUrl; }

    public String getGithubUrl() { return githubUrl; }
    public void setGithubUrl(String githubUrl) { this.githubUrl = githubUrl; }
}
