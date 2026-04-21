package org.example.backendequipos.repository;

import org.example.backendequipos.model.EstadisticaJugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EstadisticaJugadorRepository extends JpaRepository<EstadisticaJugador, Long> {

    @Query(value = """
        SELECT COALESCE(SUM(e.goles), 0)
        FROM estadistica_jugador e
        JOIN jugador j ON e.id_jugador = j.id_jugador
        WHERE j.id_equipo = :idEquipo
        """, nativeQuery = true)
    int totalGolesEquipo(@Param("idEquipo") Long idEquipo);
}