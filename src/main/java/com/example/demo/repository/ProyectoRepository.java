package com.example.demo.repository;

import com.example.demo.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
    // Buscar proyectos cuyo nombre contenga la palabra ignorando mayúsculas/minúsculas
    List<Proyecto> findByProyectoNameContainingIgnoreCase(String word);
}
