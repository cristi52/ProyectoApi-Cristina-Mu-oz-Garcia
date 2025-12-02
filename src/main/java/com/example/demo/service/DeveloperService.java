package com.example.demo.service;

import com.example.demo.model.Developer;
import com.example.demo.repository.DeveloperRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeveloperService {

    private final DeveloperRepository developerRepository;

    public DeveloperService(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    // Insertar programador
    public Developer saveDeveloper(Developer developer) {
        return developerRepository.save(developer);
    }

    // Eliminar programador
    public void deleteDeveloper(Long id) {
        developerRepository.deleteById(id);
    }

    // Obtener todos los programadores (opcional)
    public List<Developer> getAllDevelopers() {
        return developerRepository.findAll();
    }
}
