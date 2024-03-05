package de.aquazen.backend.ph.service;

import de.aquazen.backend.ph.domain.Ph;
import de.aquazen.backend.ph.repository.PhRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhService {
    private final PhRepository phRepository;

    public PhService(PhRepository phRepository) {
        this.phRepository = phRepository;
    }

    public List<Ph> findAllPhProbes() {

    }

    public Optional<Ph> findPhProbeById(Long id) {

    }

    public Ph createPhProbe(Ph pH) {

    }

    public Ph updatePhProbe(Long id, Ph pH) {

    }

    public void deletePhProbe(Long id) {

    }
}
