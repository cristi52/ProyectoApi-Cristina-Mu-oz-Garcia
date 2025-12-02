package com.example.demo.controller;

import com.example.demo.model.Technology;
import com.example.demo.service.TechnologyService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/technologies")
public class TechnologyController {

    private final TechnologyService technologyService;

    public TechnologyController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    // 8. POST /technologies -> insertar tecnología
    @PostMapping
    public ResponseEntity<Technology> createTechnology(@RequestBody Technology technology) {
        Technology saved = technologyService.saveTechnology(technology);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // 9. DELETE /technologies/{id} -> borrar tecnología
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTechnology(@PathVariable Long id) {
        technologyService.deleteTechnology(id);
        return ResponseEntity.noContent().build();
    }
}
