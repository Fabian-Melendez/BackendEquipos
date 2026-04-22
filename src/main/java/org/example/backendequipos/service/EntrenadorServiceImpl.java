package org.example.backendequipos.service;

import org.example.backendequipos.exception.RecursoNoEncontradoException;
import org.example.backendequipos.model.Entrenador;
import org.example.backendequipos.repository.EntrenadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrenadorServiceImpl implements EntrenadorService {

    private final EntrenadorRepository repo;

    public EntrenadorServiceImpl(EntrenadorRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Entrenador> listar() {
        return repo.findAll();
    }

    @Override
    public Entrenador guardar(Entrenador entrenador) {
        return repo.save(entrenador);
    }

    @Override
    public Entrenador obtenerPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("No encontrado..."));
    }

    @Override
    public Entrenador actualizar(Long id, Entrenador entrenador) {
        Entrenador existente = obtenerPorId(id);

        existente.setNombre(entrenador.getNombre());
        existente.setEspecialidad(entrenador.getEspecialidad());
        existente.setEquipo(entrenador.getEquipo());

        return repo.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}