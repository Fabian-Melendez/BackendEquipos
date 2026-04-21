package org.example.backendequipos.service;

import org.example.backendequipos.model.Entrenador;
import java.util.List;

public interface EntrenadorService {

    List<Entrenador> listar();

    Entrenador guardar(Entrenador entrenador);

    Entrenador obtenerPorId(Long id);

    Entrenador actualizar(Long id, Entrenador entrenador);

    void eliminar(Long id);
}