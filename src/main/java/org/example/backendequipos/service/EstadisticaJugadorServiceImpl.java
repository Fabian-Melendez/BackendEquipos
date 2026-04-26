package org.example.backendequipos.service;

import org.example.backendequipos.exception.RecursoNoEncontradoException;
import org.example.backendequipos.model.EstadisticaJugador;
import org.example.backendequipos.model.Jugador;
import org.example.backendequipos.model.Partido;
import org.example.backendequipos.repository.EstadisticaJugadorRepository;
import org.example.backendequipos.repository.JugadorRepository;
import org.example.backendequipos.repository.PartidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadisticaJugadorServiceImpl implements EstadisticaJugadorService {

    private final EstadisticaJugadorRepository repo;
    private final JugadorRepository jugadorRepo;
    private final PartidoRepository partidoRepo;

    public EstadisticaJugadorServiceImpl(EstadisticaJugadorRepository repo,
                                         JugadorRepository jugadorRepo,
                                         PartidoRepository partidoRepo) {
        this.repo = repo;
        this.jugadorRepo = jugadorRepo;
        this.partidoRepo = partidoRepo;
    }

    @Override
    public List<EstadisticaJugador> listar() {
        return repo.findAll();
    }

    @Override
    public EstadisticaJugador crear(EstadisticaJugador estadistica) {

        // 🔥 Validaciones
        if (estadistica.getJugador() == null || estadistica.getJugador().getIdJugador() == null) {
            throw new RuntimeException("Debe enviar el id del jugador");
        }

        if (estadistica.getPartido() == null || estadistica.getPartido().getIdPartido() == null) {
            throw new RuntimeException("Debe enviar el id del partido");
        }

        // 🔥 Buscar entidades reales en BD
        Jugador jugador = jugadorRepo.findById(
                estadistica.getJugador().getIdJugador()
        ).orElseThrow(() -> new RecursoNoEncontradoException("Jugador no encontrado"));

        Partido partido = partidoRepo.findById(
                estadistica.getPartido().getIdPartido()
        ).orElseThrow(() -> new RecursoNoEncontradoException("Partido no encontrado"));

        // 🔥 Asignar entidades gestionadas
        estadistica.setJugador(jugador);
        estadistica.setPartido(partido);

        return repo.save(estadistica);
    }

    @Override
    public EstadisticaJugador obtenerPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Estadística no encontrada"));
    }

    @Override
    public EstadisticaJugador actualizar(Long id, EstadisticaJugador estadistica) {

        EstadisticaJugador existente = obtenerPorId(id);

        // 🔥 Validar IDs
        if (estadistica.getJugador() == null || estadistica.getJugador().getIdJugador() == null) {
            throw new RuntimeException("Debe enviar el id del jugador");
        }

        if (estadistica.getPartido() == null || estadistica.getPartido().getIdPartido() == null) {
            throw new RuntimeException("Debe enviar el id del partido");
        }

        // 🔥 Buscar entidades reales
        Jugador jugador = jugadorRepo.findById(
                estadistica.getJugador().getIdJugador()
        ).orElseThrow(() -> new RecursoNoEncontradoException("Jugador no encontrado"));

        Partido partido = partidoRepo.findById(
                estadistica.getPartido().getIdPartido()
        ).orElseThrow(() -> new RecursoNoEncontradoException("Partido no encontrado"));

        // 🔥 Actualizar correctamente
        existente.setJugador(jugador);
        existente.setPartido(partido);
        existente.setMinutosJugados(estadistica.getMinutosJugados());
        existente.setGoles(estadistica.getGoles());
        existente.setAsistencias(estadistica.getAsistencias());
        existente.setTarjetasAmarillas(estadistica.getTarjetasAmarillas());
        existente.setTarjetasRojas(estadistica.getTarjetasRojas());

        return repo.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        if (!repo.existsById(id)) {
            throw new RecursoNoEncontradoException("Estadística no encontrada");
        }
        repo.deleteById(id);
    }

    @Override
    public int totalGolesEquipo(Long id) {
        return repo.totalGolesEquipo(id);
    }
}