package org.example.backendequipos.repository;

import org.example.backendequipos.model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PartidoRepository extends JpaRepository<Partido, Long> {

    @Query(value = """
        SELECT el.nombre, ev.nombre, p.goles_local, p.goles_visita
        FROM partido p
        JOIN equipo el ON p.equipo_local_id = el.id_equipo
        JOIN equipo ev ON p.equipo_visita_id = ev.id_equipo
        """, nativeQuery = true)
    List<Object[]> resultadosPartidos();
}