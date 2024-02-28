package de.aquazen.backend.analoginput.service;

import de.aquazen.backend.analoginput.domain.AnalogInput;
import de.aquazen.backend.analoginput.repository.AnalogInputRepository;
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

    }

    public Optional<AnalogInput> findAnalogInputById(Long id) {

    }

    public AnalogInput createAnalogInput(AnalogInput input) {

    }

    public AnalogInput updateAnalogInput(Long id, AnalogInput input) {

    }

    public void deleteAnalogInput(Long id) {

    }
}
