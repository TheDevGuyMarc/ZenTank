package de.aquazen.backend.waves.service;

import de.aquazen.backend.lighting.domain.Lighting;
import de.aquazen.backend.lighting.exception.LightingNotFoundException;
import de.aquazen.backend.lighting.repository.LightingEntity;
import de.aquazen.backend.waves.domain.Wave;
import de.aquazen.backend.waves.exception.WaveNotFoundException;
import de.aquazen.backend.waves.repository.WaveEntity;
import de.aquazen.backend.waves.repository.WaveRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WaveService {
    private final WaveRepository waveRepository;

    public WaveService(WaveRepository waveRepository) {
        this.waveRepository = waveRepository;
    }

    public List<Wave> findAllWaves() {
        return this.waveRepository.findAll()
            .stream()
            .map(Wave::new)
            .toList();
    }

    public Optional<Wave> findWaveById(Long id) {
        return this.waveRepository.findById(id)
            .map(Wave::new);
    }

    public Wave createWave(Wave wave) {
        return new Wave(this.waveRepository.saveAndFlush(new WaveEntity(wave)));
    }

    public Wave updateWave(Long id, Wave wave) {
        Optional<Wave> existingElement = this.waveRepository.findById(id)
            .map(Wave::new);

        if (existingElement.isPresent()) {
            Wave updatedElement = existingElement.get();

            updatedElement.setId(wave.getId());
            updatedElement.setName(wave.getName());
            updatedElement.setState(wave.isState());
            updatedElement.setJack(wave.getJack());
            updatedElement.setChannels(wave.getChannels());

            return new Wave(this.waveRepository.saveAndFlush(new WaveEntity(updatedElement)));
        }
        else {
            throw new WaveNotFoundException("Couldn't find the wave system entry you requested with id: " + id);
        }
    }

    public void deleteWave(Long id) {
        this.waveRepository.deleteById(id);
    }

    public void history(Long id) {
        /* TODO: Implement this method */

        /*
         * Concept:
         * This should return the usage history of the light
         */
    }
}
