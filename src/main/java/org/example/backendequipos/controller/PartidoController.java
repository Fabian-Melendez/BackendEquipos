package org.example.backendequipos.controller;

import org.example.backendequipos.model.Partido;
import org.example.backendequipos.service.PartidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partidos")
@CrossOrigin(origins = "*")
public class PartidoController {

    private final PartidoService service;

    public PartidoController(PartidoService service) {
        this.service = service;
    }

    @PostMapping
    public Partido guardar(@RequestBody Partido partido) {
        return service.guardar(partido);
    }

    @GetMapping
    public List<Partido> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Partido obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public Partido actualizar(@PathVariable Long id, @RequestBody Partido partido) {
        return service.actualizar(id, partido);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    @GetMapping("/resultados")
    public List<Object[]> resultados() {
        return service.resultados();
    }
}