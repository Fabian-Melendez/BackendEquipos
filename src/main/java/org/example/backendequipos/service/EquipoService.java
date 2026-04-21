package org.example.backendequipos.service;

import org.example.backendequipos.model.Equipo;
import java.util.List;

public interface EquipoService {

    List<Equipo> listar();

    Equipo guardar(Equipo equipo);

    Equipo obtenerPorId(Long id);

    Equipo actualizar(Long id, Equipo equipo);

    void eliminar(Long id);
}