package de.aquazen.backend.jacks.service;

import de.aquazen.backend.jacks.domain.Jack;
import de.aquazen.backend.jacks.exception.JackNotFoundException;
import de.aquazen.backend.jacks.repository.JackEntity;
import de.aquazen.backend.jacks.repository.JackRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JackService {
    private final JackRepository jackRepository;

    public JackService(JackRepository jackRepository) {
        this.jackRepository = jackRepository;
    }

    public List<Jack> findAllJacks() {
        return this.jackRepository.findAll()
            .stream()
            .map(Jack::new)
            .toList();
    }

    public Optional<Jack> findJackById(Long id) {
        return this.jackRepository.findById(id)
            .map(Jack::new);
    }

    public Jack createJack(Jack jack) {
        return new Jack(this.jackRepository.saveAndFlush(new JackEntity(jack)));
    }

    public Jack updateJack(Long id, Jack jack) {
        Optional<Jack> existingElement = this.jackRepository.findById(id)
            .map(Jack::new);

        if (existingElement.isPresent()) {
            Jack updatedElement = existingElement.get();

            updatedElement.setId(jack.getId());
            updatedElement.setName(jack.getName());
            updatedElement.setPinMap(jack.getPinMap());
            updatedElement.setReverse(jack.isReverse());
            updatedElement.setState(jack.isState());
            updatedElement.setDriver(jack.getDriver());

            return new Jack(this.jackRepository.saveAndFlush(new JackEntity(updatedElement)));
        }
        else {
            throw new JackNotFoundException("Couldn't find the jack entry you requested with id: " + id);
        }
    }

    public void deleteJack(Long id) {
        this.jackRepository.deleteById(id);
    }

    public void stop(Long id) {
        /* TODO: Implement this method */

        /*
         * Concept:
         * This should stop the PWM signal
         */
    }

    public void pulse(Long id) {
        /* TODO: Implement this method */

        /*
         * Concept:
         * This should create a pulsing PWM signal
         */
    }

    public void fade(Long id) {
        /* TODO: Implement this method */

        /*
         * Concept:
         * This should create a fading transition between PWM signals
         */
    }

    public void ramUp(Long id) {
        /* TODO: Implement this method */

        /*
         * Concept:
         * This should steadily increase the PWM signal
         */
    }

    public void rampDown(Long id) {
        /* TODO: Implement this method */

        /*
         * Concept:
         * This should steadily decrease the PWM signal
         */
    }
}
