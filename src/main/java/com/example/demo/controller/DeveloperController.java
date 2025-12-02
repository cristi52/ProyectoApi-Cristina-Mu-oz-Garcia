package com.example.demo.controller;

import com.example.demo.model.Developer;
import com.example.demo.service.DeveloperService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperController {

    private final DeveloperService developerService;

    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    // 6. POST /developers -> insertar programador
    @PostMapping
    public ResponseEntity<Developer> createDeveloper(@RequestBody Developer developer) {
        Developer saved = developerService.saveDeveloper(developer);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // 7. DELETE /developers/{id} -> borrar programador
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeveloper(@PathVariable Long id) {
        developerService.deleteDeveloper(id);
        return ResponseEntity.noContent().build();
    }
}
