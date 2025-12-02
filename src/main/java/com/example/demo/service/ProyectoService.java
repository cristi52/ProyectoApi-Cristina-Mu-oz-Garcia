package com.example.demo.service;

import com.example.demo.model.Proyecto;
import com.example.demo.repository.ProyectoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyectoService {

    private final ProyectoRepository proyectoRepository;

    public ProyectoService(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }

    // Obtener todos los proyectos
    public List<Proyecto> getAllProyectos() {
        return proyectoRepository.findAll();
    }

    // Buscar proyectos cuyo nombre contenga una palabra (ignorando mayúsculas/minúsculas)
    public List<Proyecto> getProyectosByWord(String word) {
        return proyectoRepository.findByProyectoNameContainingIgnoreCase(word);
    }

    // Insertar proyecto
    public Proyecto saveProyecto(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    // Editar proyecto
    public Optional<Proyecto> updateProyecto(Long id, Proyecto proyecto) {
    return proyectoRepository.findById(id).map(existing -> {
        existing.setProyectoName(proyecto.getProyectoName());
        existing.setDescription(proyecto.getDescription());
        existing.setStartDate(proyecto.getStartDate());
        existing.setEndDate(proyecto.getEndDate());
        existing.setDemoUrl(proyecto.getDemoUrl());
        existing.setPicture(proyecto.getPicture());
        existing.setStatus(proyecto.getStatus()); // 👈 usamos statusId en lugar de status
        return proyectoRepository.save(existing);
    });
}


    // Eliminar proyecto
    public void deleteProyecto(Long id) {
        proyectoRepository.deleteById(id);
    }
}
