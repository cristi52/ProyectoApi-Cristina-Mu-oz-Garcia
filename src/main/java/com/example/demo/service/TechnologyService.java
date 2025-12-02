package com.example.demo.service;

import com.example.demo.model.Technology;
import com.example.demo.repository.TechnologyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyService {

    private final TechnologyRepository technologyRepository;

    public TechnologyService(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    // Insertar tecnología
    public Technology saveTechnology(Technology technology) {
        return technologyRepository.save(technology);
    }

    // Eliminar tecnología
    public void deleteTechnology(Long id) {
        technologyRepository.deleteById(id);
    }

    // Obtener todas las tecnologías (opcional)
    public List<Technology> getAllTechnologies() {
        return technologyRepository.findAll();
    }
}
