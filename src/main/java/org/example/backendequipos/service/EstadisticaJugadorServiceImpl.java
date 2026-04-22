package org.example.backendequipos.service;

import org.example.backendequipos.exception.RecursoNoEncontradoException;
import org.example.backendequipos.model.EstadisticaJugador;
import org.example.backendequipos.repository.EstadisticaJugadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadisticaJugadorServiceImpl implements EstadisticaJugadorService {

    private final EstadisticaJugadorRepository repo;

    public EstadisticaJugadorServiceImpl(EstadisticaJugadorRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<EstadisticaJugador> listar() {
        return repo.findAll();
    }

    @Override
    public EstadisticaJugador crear(EstadisticaJugador estadistica) {
        return repo.save(estadistica);
    }

    @Override
    public EstadisticaJugador obtenerPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("No encontrado..."));
    }

    @Override
    public EstadisticaJugador actualizar(Long id, EstadisticaJugador estadistica) {
        EstadisticaJugador existente = obtenerPorId(id);

        existente.setJugador(estadistica.getJugador());
        existente.setPartido(estadistica.getPartido());
        existente.setMinutosJugados(estadistica.getMinutosJugados());
        existente.setGoles(estadistica.getGoles());
        existente.setAsistencias(estadistica.getAsistencias());
        existente.setTarjetasAmarillas(estadistica.getTarjetasAmarillas());
        existente.setTarjetasRojas(estadistica.getTarjetasRojas());

        return repo.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    @Override
    public int totalGolesEquipo(Long id) {
        return repo.totalGolesEquipo(id);
    }
}