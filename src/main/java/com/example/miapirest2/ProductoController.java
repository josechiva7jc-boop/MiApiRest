package com.example.miapirest2;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoRepository repository;

    public ProductoController(ProductoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Producto> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Producto getById(@PathVariable int id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Producto crear(@RequestBody Producto producto) {
        return repository.save(producto);
    }

    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable int id, @RequestBody Producto productoActualizado) {
        Producto p = repository.findById(id).orElse(null);
        if (p != null) {
            p.setNombre(productoActualizado.getNombre());
            p.setPrecio(productoActualizado.getPrecio());
            return repository.save(p);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        repository.deleteById(id);
        return "Producto " + id + " eliminado";
    }
}