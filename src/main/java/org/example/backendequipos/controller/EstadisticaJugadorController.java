package org.example.backendequipos.controller;

import org.example.backendequipos.model.EstadisticaJugador;
import org.example.backendequipos.service.EstadisticaJugadorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estadisticas")
@CrossOrigin(origins = "*")
public class EstadisticaJugadorController {

    private final EstadisticaJugadorService service;

    public EstadisticaJugadorController(EstadisticaJugadorService service) {
        this.service = service;
    }

    @PostMapping
    public EstadisticaJugador crear(@RequestBody EstadisticaJugador estadistica) {
        return service.crear(estadistica);
    }

    @GetMapping
    public List<EstadisticaJugador> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public EstadisticaJugador obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public EstadisticaJugador actualizar(@PathVariable Long id, @RequestBody EstadisticaJugador estadistica) {
        return service.actualizar(id, estadistica);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    @GetMapping("/goles-equipo/{id}")
    public int totalGoles(@PathVariable Long id) {
        return service.totalGolesEquipo(id);
    }
}