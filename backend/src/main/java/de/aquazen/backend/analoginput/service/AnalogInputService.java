package de.aquazen.backend.analoginput.service;

import de.aquazen.backend.analoginput.domain.AnalogInput;
import de.aquazen.backend.analoginput.exception.AnalogInputNotFoundException;
import de.aquazen.backend.analoginput.repository.AnalogInputEntity;
import de.aquazen.backend.analoginput.repository.AnalogInputRepository;
import de.aquazen.backend.jacks.domain.Jack;
import de.aquazen.backend.jacks.exception.JackNotFoundException;
import de.aquazen.backend.jacks.repository.JackEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnalogInputService {
    private final AnalogInputRepository analogInputRepository;

    public AnalogInputService(AnalogInputRepository analogInputRepository) {
        this.analogInputRepository = analogInputRepository;
    }

    public List<AnalogInput> findAllAnalogInputs() {
        return this.analogInputRepository.findAll()
            .stream()
            .map(AnalogInput::new)
            .toList();
    }

    public Optional<AnalogInput> findAnalogInputById(Long id) {
        return this.analogInputRepository.findById(id)
            .map(AnalogInput::new);
    }

    public AnalogInput createAnalogInput(AnalogInput input) {
        return new AnalogInput(this.analogInputRepository.saveAndFlush(new AnalogInputEntity(input)));
    }

    public AnalogInput updateAnalogInput(Long id, AnalogInput input) {
        Optional<AnalogInput> existingElement = this.analogInputRepository.findById(id)
            .map(AnalogInput::new);

        if (existingElement.isPresent()) {
            AnalogInput updatedElement = existingElement.get();

            updatedElement.setId(input.getId());
            updatedElement.setName(input.getName());
            updatedElement.setPin(input.getPin());
            updatedElement.setState(input.isState());
            updatedElement.setDriver(input.getDriver());

            return new AnalogInput(this.analogInputRepository.saveAndFlush(new AnalogInputEntity(updatedElement)));
        }
        else {
            throw new AnalogInputNotFoundException("Couldn't find the analog-input entry you requested with id: " + id);
        }
    }

    public void deleteAnalogInput(Long id) {
        this.analogInputRepository.deleteById(id);
    }

    public void readData(Long id) {
        /* TODO: Implement this method */

        /*
         * Concept:
         * This should return the sensor data
         */
    }
}
