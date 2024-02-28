package de.aquazen.backend.temperature.service;

import de.aquazen.backend.temperature.domain.Temperature;
import de.aquazen.backend.temperature.repository.TemperatureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TemperatureService {
    private final TemperatureRepository temperatureRepository;

    public TemperatureService(TemperatureRepository temperatureRepository) {
        this.temperatureRepository = temperatureRepository;
    }

    public List<Temperature> findAllTemperatureProbes() {

    }

    public Optional<Temperature> findTemperatureProbeById(Long id) {

    }

    public Temperature createTemperatureProbe(Temperature probe) {

    }

    public Temperature updateTemperatureProbe(Long id, Temperature probe) {

    }

    public void deleteTemperatureProbe(Long id) {

    }
}
