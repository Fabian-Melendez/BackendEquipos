package org.example.backendequipos.service;

import org.example.backendequipos.model.Partido;
import java.util.List;

public interface PartidoService {

    List<Partido> listar();

    Partido guardar(Partido partido);

    Partido obtenerPorId(Long id);

    Partido actualizar(Long id, Partido partido);

    void eliminar(Long id);

    List<Object[]> resultados();
}