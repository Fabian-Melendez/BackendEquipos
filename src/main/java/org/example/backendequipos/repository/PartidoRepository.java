package org.example.backendequipos.repository;

import org.example.backendequipos.dto.ResultadoPartidoDTO;
import org.example.backendequipos.model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PartidoRepository extends JpaRepository<Partido, Long> {

    @Query("""
        SELECT new org.example.backendequipos.dto.ResultadoPartidoDTO(
            el.nombre, ev.nombre, p.golesLocal, p.golesVisita
        )
        FROM Partido p
        JOIN p.equipoLocal el
        JOIN p.equipoVisita ev
    """)
    List<ResultadoPartidoDTO> resultadosPartidos();
}