package com.example.miapirest2;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    private final EstudianteRepository repository;

    public EstudianteController(EstudianteRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Estudiante> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Estudiante create(@RequestBody Estudiante estudiante) {
        return repository.save(estudiante);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        repository.deleteById(id);
        return "Estudiante " + id + " eliminado";
    }
}
