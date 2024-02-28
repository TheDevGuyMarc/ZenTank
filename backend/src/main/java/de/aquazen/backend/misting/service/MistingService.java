package de.aquazen.backend.misting.service;

import de.aquazen.backend.misting.domain.Misting;
import de.aquazen.backend.misting.repository.MistingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MistingService {
    private final MistingRepository mistingRepository;

    public MistingService(MistingRepository mistingRepository) {
        this.mistingRepository = mistingRepository;
    }

    public List<Misting> findAllMistings() {

    }

    public Optional<Misting> findMistingById(Long id) {

    }

    public Misting createMisting(Misting misting) {

    }

    public Misting updateMisting(Long id, Misting misting) {

    }

    public void deleteMisting(Long id) {

    }
}
