package org.example.backendequipos.service;

import org.example.backendequipos.model.Partido;
import org.example.backendequipos.repository.PartidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidoServiceImpl implements PartidoService {

    private final PartidoRepository repo;

    public PartidoServiceImpl(PartidoRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Partido> listar() {
        return repo.findAll();
    }

    @Override
    public Partido guardar(Partido partido) {
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

        existente.setFecha(partido.getFecha());
        existente.setEstadio(partido.getEstadio());
        existente.setEquipoLocal(partido.getEquipoLocal());
        existente.setEquipoVisita(partido.getEquipoVisita());
        existente.setGolesLocal(partido.getGolesLocal());
        existente.setGolesVisita(partido.getGolesVisita());

        return repo.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Object[]> resultados() {
        return repo.resultadosPartidos();
    }
}