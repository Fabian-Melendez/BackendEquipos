package org.example.backendequipos.service;

import org.example.backendequipos.model.Jugador;
import java.util.List;

public interface JugadorService {

    List<Jugador> listar();

    Jugador guardar(Jugador jugador);

    Jugador obtenerPorId(Long id);

    Jugador actualizar(Long id, Jugador jugador);

    void eliminar(Long id);

    List<Jugador> porEquipo(Long id);

    List<Jugador> goleadores(int goles);
}