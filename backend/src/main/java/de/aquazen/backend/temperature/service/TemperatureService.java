package de.aquazen.backend.temperature.service;

import de.aquazen.backend.temperature.domain.Temperature;
import de.aquazen.backend.temperature.exception.TemperatureNotFoundException;
import de.aquazen.backend.temperature.repository.TemperatureEntity;
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
        return this.temperatureRepository.findAll()
            .stream()
            .map(Temperature::new)
            .toList();
    }

    public Optional<Temperature> findTemperatureProbeById(Long id) {
        return this.temperatureRepository.findById(id)
            .map(Temperature::new);
    }

    public Temperature createTemperatureProbe(Temperature probe) {
        return new Temperature(this.temperatureRepository.saveAndFlush(new TemperatureEntity(probe)));
    }

    public Temperature updateTemperatureProbe(Long id, Temperature probe) {
        Optional<Temperature> existingElement = this.temperatureRepository.findById(id)
            .map(Temperature::new);

        if (existingElement.isPresent()) {
            Temperature updatedElement = existingElement.get();

            updatedElement.setId(probe.getId());
            updatedElement.setName(probe.getName());
            updatedElement.setFahrenheit(probe.isFahrenheit());
            updatedElement.setAlerts(probe.isAlerts());
            updatedElement.setMin(probe.getMin());
            updatedElement.setMax(probe.getMax());
            updatedElement.setHeaterThreshold(probe.getHeaterThreshold());
            updatedElement.setCoolerThreshold(probe.getCoolerThreshold());
            updatedElement.setCheckFrequency(probe.getCheckFrequency());
            updatedElement.setSensorState(probe.getSensorState());
            updatedElement.setCooler(probe.getCooler());
            updatedElement.setHeater(probe.getHeater());

            return new Temperature(this.temperatureRepository.saveAndFlush(new TemperatureEntity(updatedElement)));
        }
        else {
            throw new TemperatureNotFoundException("Couldn't find the temperature entry you requested with id: " + id);
        }
    }

    public void deleteTemperatureProbe(Long id) {
        this.temperatureRepository.deleteById(id);
    }

    public void readData(Long id) {
        /* TODO: Implement this method */

        /*
         * Concept:
         * This should return sensoric data for temperatures
         */
    }
}
