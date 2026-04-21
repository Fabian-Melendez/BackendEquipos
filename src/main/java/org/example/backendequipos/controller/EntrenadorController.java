package org.example.backendequipos.controller;

import org.example.backendequipos.model.Entrenador;
import org.example.backendequipos.service.EntrenadorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entrenadores")
@CrossOrigin(origins = "*")
public class EntrenadorController {

    private final EntrenadorService service;

    public EntrenadorController(EntrenadorService service) {
        this.service = service;
    }

    @PostMapping
    public Entrenador guardar(@RequestBody Entrenador entrenador) {
        return service.guardar(entrenador);
    }

    @GetMapping
    public List<Entrenador> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Entrenador obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public Entrenador actualizar(@PathVariable Long id, @RequestBody Entrenador entrenador) {
        return service.actualizar(id, entrenador);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}