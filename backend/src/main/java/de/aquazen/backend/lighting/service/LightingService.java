package de.aquazen.backend.lighting.service;

import de.aquazen.backend.channel.domain.Channel;
import de.aquazen.backend.channel.exception.ChannelNotFoundException;
import de.aquazen.backend.channel.repository.ChannelEntity;
import de.aquazen.backend.lighting.domain.Lighting;
import de.aquazen.backend.lighting.exception.LightingNotFoundException;
import de.aquazen.backend.lighting.repository.LightingEntity;
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
        return this.lightingRepository.findAll()
            .stream()
            .map(Lighting::new)
            .toList();
    }

    public Optional<Lighting> findLightById(Long id) {
        return this.lightingRepository.findById(id)
            .map(Lighting::new);
    }

    public Lighting createLight(Lighting lighting) {
        return new Lighting(this.lightingRepository.saveAndFlush(new LightingEntity(lighting)));
    }

    public Lighting updateLight(Long id, Lighting lighting) {
        Optional<Lighting> existingElement = this.lightingRepository.findById(id)
            .map(Lighting::new);

        if (existingElement.isPresent()) {
            Lighting updatedElement = existingElement.get();

            updatedElement.setId(lighting.getId());
            updatedElement.setName(lighting.getName());
            updatedElement.setState(lighting.isState());
            updatedElement.setJack(lighting.getJack());
            updatedElement.setChannels(lighting.getChannels());

            return new Lighting(this.lightingRepository.saveAndFlush(new LightingEntity(updatedElement)));
        }
        else {
            throw new LightingNotFoundException("Couldn't find the light entry you requested with id: " + id);
        }
    }

    public void deleteLight(Long id) {
        this.lightingRepository.deleteById(id);
    }

    public void history(Long id) {
        /* TODO: Implement this method */

        /*
         * Concept:
         * This should return the usage history of the light
         */
    }
}
