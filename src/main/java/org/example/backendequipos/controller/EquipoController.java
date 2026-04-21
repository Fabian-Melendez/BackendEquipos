package org.example.backendequipos.controller;

import org.example.backendequipos.model.Equipo;
import org.example.backendequipos.service.EquipoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipos")
@CrossOrigin(origins = "*")
public class EquipoController {

    private final EquipoService service;

    public EquipoController(EquipoService service) {
        this.service = service;
    }

    @PostMapping
    public Equipo guardar(@RequestBody Equipo e) {
        return service.guardar(e);
    }

    @GetMapping
    public List<Equipo> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Equipo obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public Equipo actualizar(@PathVariable Long id, @RequestBody Equipo e) {
        return service.actualizar(id, e);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}