package org.example.backendequipos.service;

import org.example.backendequipos.model.EstadisticaJugador;
import java.util.List;

public interface EstadisticaJugadorService {

    EstadisticaJugador crear(EstadisticaJugador estadistica);

    List<EstadisticaJugador> listar();

    EstadisticaJugador obtenerPorId(Long id);

    EstadisticaJugador actualizar(Long id, EstadisticaJugador estadistica);

    void eliminar(Long id);

    int totalGolesEquipo(Long id);
}