package org.example.backendequipos.service;

import org.example.backendequipos.model.Partido;
import org.example.backendequipos.model.Equipo;
import org.example.backendequipos.repository.PartidoRepository;
import org.example.backendequipos.repository.EquipoRepository;
import org.springframework.stereotype.Service;
import org.example.backendequipos.dto.ResultadoPartidoDTO;

import java.util.List;

@Service
public class PartidoServiceImpl implements PartidoService {

    private final PartidoRepository repo;
    private final EquipoRepository equipoRepository;

    public PartidoServiceImpl(PartidoRepository repo, EquipoRepository equipoRepository) {
        this.repo = repo;
        this.equipoRepository = equipoRepository;
    }

    @Override
    public List<Partido> listar() {
        return repo.findAll();
    }

    @Override
    public Partido guardar(Partido partido) {

        Equipo local = equipoRepository.findById(
                partido.getEquipoLocal().getIdEquipo()
        ).orElseThrow(() -> new RuntimeException("Equipo local no existe"));

        Equipo visita = equipoRepository.findById(
                partido.getEquipoVisita().getIdEquipo()
        ).orElseThrow(() -> new RuntimeException("Equipo visita no existe"));

        partido.setEquipoLocal(local);
        partido.setEquipoVisita(visita);

        return repo.save(partido);
    }

    @Override
    public Partido obtenerPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Partido no encontrado con id " + id));
    }

    @Override
    public Partido actualizar(Long id, Partido partido) {

        Partido existente = obtenerPorId(id);

        Equipo local = equipoRepository.findById(
                partido.getEquipoLocal().getIdEquipo()
        ).orElseThrow(() -> new RuntimeException("Equipo local no existe"));

        Equipo visita = equipoRepository.findById(
                partido.getEquipoVisita().getIdEquipo()
        ).orElseThrow(() -> new RuntimeException("Equipo visita no existe"));

        existente.setFecha(partido.getFecha());
        existente.setEstadio(partido.getEstadio());
        existente.setEquipoLocal(local);
        existente.setEquipoVisita(visita);
        existente.setGolesLocal(partido.getGolesLocal());
        existente.setGolesVisita(partido.getGolesVisita());

        return repo.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<ResultadoPartidoDTO> resultados() {
        return repo.resultadosPartidos();
    }
}