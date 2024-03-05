package de.aquazen.backend.lighting.service;

import de.aquazen.backend.lighting.domain.Lighting;
import de.aquazen.backend.lighting.repository.LightingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LightingService {
    private final LightingRepository lightingRepository;

    public LightingService(LightingRepository lightingRepository) {
        this.lightingRepository = lightingRepository;
    }

    public List<Lighting> findAllLights() {

    }

    public Optional<Lighting> findLightById(Long id) {

    }

    public Lighting createLight(Lighting lighting) {

    }

    public Lighting updateLight(Long id, Lighting lighting) {

    }

    public void deleteLight(Long id) {

    }
}
