package com.example.demo.controller;

import com.example.demo.model.Proyecto;
import com.example.demo.service.ProyectoService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
public class ProyectoController {

    private final ProyectoService proyectoService;

    public ProyectoController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }

    // 1. GET /projects -> obtener todos los proyectos
    @GetMapping
    public ResponseEntity<List<Proyecto>> getAllProjects() {
        return ResponseEntity.ok(proyectoService.getAllProyectos());
    }

    // 2. GET /projects/{word} -> buscar proyectos por palabra en el nombre
    @GetMapping("/{word}")
    public ResponseEntity<List<Proyecto>> getProjectsByWord(@PathVariable String word) {
        return ResponseEntity.ok(proyectoService.getProyectosByWord(word));
    }

    // 3. POST /projects -> insertar proyecto
    @PostMapping
    public ResponseEntity<Proyecto> createProject(@RequestBody Proyecto proyecto) {
        Proyecto saved = proyectoService.saveProyecto(proyecto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // 4. PUT /projects/{id} -> editar proyecto
    @PutMapping("/{id}")
    public ResponseEntity<Proyecto> updateProject(@PathVariable Long id, @RequestBody Proyecto proyecto) {
        return proyectoService.updateProyecto(id, proyecto)
                .map(updated -> ResponseEntity.ok(updated))
                .orElse(ResponseEntity.notFound().build());
    }

    // 5. DELETE /projects/{id} -> eliminar proyecto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        proyectoService.deleteProyecto(id);
        return ResponseEntity.noContent().build();
    }
}
