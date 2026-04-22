package org.example.backendequipos.service;

import org.example.backendequipos.exception.RecursoNoEncontradoException;
import org.example.backendequipos.model.Equipo;
import org.example.backendequipos.repository.EquipoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoServiceImpl implements EquipoService {

    private final EquipoRepository repo;

    public EquipoServiceImpl(EquipoRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Equipo> listar() {
        return repo.findAll();
    }

    @Override
    public Equipo guardar(Equipo equipo) {
        return repo.save(equipo);
    }

    @Override
    public Equipo obtenerPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("No encontrado..."));
    }

    @Override
    public Equipo actualizar(Long id, Equipo equipo) {
        Equipo existente = obtenerPorId(id);

        existente.setNombre(equipo.getNombre());
        existente.setCiudad(equipo.getCiudad());
        existente.setFundacion(equipo.getFundacion());

        return repo.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}