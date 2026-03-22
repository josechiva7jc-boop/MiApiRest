package com.example.miapirest2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pelicula")


public class PeliculaController {

    private final PeliculaRepository repository;

    public PeliculaController(PeliculaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Pelicula> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> getById(@PathVariable int id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pelicula crear(@RequestBody Pelicula pelicula) {
        return repository.save(pelicula);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        repository.deleteById(id);
        return "Pelicula " + id + " eliminada";
    }
}
