package de.aquazen.backend.ato.service;

import de.aquazen.backend.ato.domain.Ato;
import de.aquazen.backend.ato.repository.AtoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtoService {
    private final AtoRepository atoRepository;

    public AtoService(AtoRepository atoRepository) {
        this.atoRepository = atoRepository;
    }

    public List<Ato> findAllAtos() {

    }

    public Optional<Ato> findAtoById(Long id) {

    }

    public Ato createAto(Ato ato) {

    }

    public Ato updateAto(Long id, Ato ato) {

    }

    public void deleteAto(Long id) {

    }
}
