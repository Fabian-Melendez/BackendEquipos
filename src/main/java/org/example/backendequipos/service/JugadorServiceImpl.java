package org.example.backendequipos.service;

import org.example.backendequipos.exception.RecursoNoEncontradoException;
import org.example.backendequipos.model.Jugador;
import org.example.backendequipos.repository.JugadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadorServiceImpl implements JugadorService {

    private final JugadorRepository repo;

    public JugadorServiceImpl(JugadorRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Jugador> listar() {
        return repo.findAll();
    }

    @Override
    public Jugador guardar(Jugador jugador) {
        return repo.save(jugador);
    }

    @Override
    public Jugador obtenerPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("No encontrado..."));
    }

    @Override
    public Jugador actualizar(Long id, Jugador jugador) {
        Jugador existente = obtenerPorId(id);

        existente.setNombre(jugador.getNombre());
        existente.setPosicion(jugador.getPosicion());
        existente.setDorsal(jugador.getDorsal());
        existente.setFechaNac(jugador.getFechaNac());
        existente.setNacionalidad(jugador.getNacionalidad());
        existente.setEquipo(jugador.getEquipo());

        return repo.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Jugador> porEquipo(Long id) {
        return repo.findByEquipo(id);
    }

    @Override
    public List<Jugador> goleadores(int goles) {
        return repo.jugadoresConMasDeXGoles(goles);
    }
}