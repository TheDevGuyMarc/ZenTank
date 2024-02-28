package de.aquazen.backend.waves.service;

import de.aquazen.backend.waves.domain.Wave;
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

    }

    public Optional<Wave> findWaveById(Long id) {

    }

    public Wave createWave(Wave wave) {

    }

    public Wave updateWave(Long id, Wave wave) {

    }

    public void deleteWave(Long id) {

    }
}
