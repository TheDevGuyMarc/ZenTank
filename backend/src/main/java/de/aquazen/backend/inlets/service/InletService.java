package de.aquazen.backend.inlets.service;

import de.aquazen.backend.inlets.domain.Inlet;
import de.aquazen.backend.inlets.repository.InletRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InletService {
    private final InletRepository inletRepository;

    public InletService(InletRepository inletRepository) {
        this.inletRepository = inletRepository;
    }

    public List<Inlet> findAllInlets() {

    }

    public Optional<Inlet> findInletById(Long id) {

    }

    public Inlet createInlet(Inlet inlet) {

    }

    public Inlet updateInlet(Long id, Inlet inlet) {

    }

    public void deleteInlet(Long id) {

    }
}
