package org.example.backendequipos.controller;

import org.example.backendequipos.model.Jugador;
import org.example.backendequipos.service.JugadorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jugadores")
@CrossOrigin(origins = "*")
public class JugadorController {

    private final JugadorService service;

    public JugadorController(JugadorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Jugador> listar() {
        return service.listar();
    }

    @PostMapping
    public Jugador guardar(@RequestBody Jugador j) {
        return service.guardar(j);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    @GetMapping("/equipo/{id}")
    public List<Jugador> porEquipo(@PathVariable Long id) {
        return service.porEquipo(id);
    }

    @GetMapping("/goleadores/{goles}")
    public List<Jugador> goleadores(@PathVariable int goles) {
        return service.goleadores(goles);
    }
}