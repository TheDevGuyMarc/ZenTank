package de.aquazen.backend.inlets.service;

import de.aquazen.backend.inlets.domain.Inlet;
import de.aquazen.backend.inlets.exception.InletNotFoundException;
import de.aquazen.backend.inlets.repository.InletEntity;
import de.aquazen.backend.inlets.repository.InletRepository;
import de.aquazen.backend.settings.domain.Settings;
import de.aquazen.backend.settings.exception.SettingsNotFoundException;
import de.aquazen.backend.settings.repository.SettingsEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InletService {
    private final InletRepository inletRepository;

    public InletService(InletRepository inletRepository) {
        this.inletRepository = inletRepository;
    }

    public List<Inlet> findAllInlets() {
        return this.inletRepository.findAll()
            .stream()
            .map(Inlet::new)
            .toList();
    }

    public Optional<Inlet> findInletById(Long id) {
        return this.inletRepository.findById(id)
            .map(Inlet::new);
    }

    public Inlet createInlet(Inlet inlet) {
        return new Inlet(this.inletRepository.saveAndFlush(new InletEntity(inlet)));
    }

    public Inlet updateInlet(Long id, Inlet inlet) {
        Optional<Inlet> existingElement = this.inletRepository.findById(id)
            .map(Inlet::new);

        if (existingElement.isPresent()) {
            Inlet updatedElement = existingElement.get();

            updatedElement.setId(inlet.getId());
            updatedElement.setName(inlet.getName());
            updatedElement.setPin(inlet.getPin());
            updatedElement.setReverse(inlet.isReverse());
            updatedElement.setState(inlet.isState());
            updatedElement.setDriver(inlet.getDriver());

            return new Inlet(this.inletRepository.saveAndFlush(new InletEntity(updatedElement)));
        }
        else {
            throw new InletNotFoundException("Couldn't find the inlet entry you requested with id: " + id);
        }
    }

    public void deleteInlet(Long id) {
        this.inletRepository.deleteById(id);
    }

    public void readData() {
        /* TODO: Implement this method */

        /*
         * Concept:
         * This should read the measurement data
         */
    }

    public void isTriggered() {
        /* TODO: Implement this method */

        /*
         * Concept:
         * This should return if the inlet was triggered
         */
    }

    public void addStateChangeListener() {
        /* TODO: Implement this method */

        /*
         * Concept:
         * This should add a listener that checks for state changes of the inlet
         */
    }

    public void removeStateChangeListener() {
        /* TODO: Implement this method */

        /*
         * Concept:
         * This should remove a state change listener
         */
    }
}
