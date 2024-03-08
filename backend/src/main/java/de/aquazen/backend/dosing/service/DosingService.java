package de.aquazen.backend.dosing.service;

import de.aquazen.backend.dosing.domain.Dosing;
import de.aquazen.backend.dosing.exception.DosingNotFoundException;
import de.aquazen.backend.dosing.repository.DosingEntity;
import de.aquazen.backend.dosing.repository.DosingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DosingService {
    private final DosingRepository dosingRepository;

    public DosingService(DosingRepository dosingRepository) {
        this.dosingRepository = dosingRepository;
    }

    public List<Dosing> findAllDosingSystems() {
        return this.dosingRepository.findAll()
            .stream()
            .map(Dosing::new)
            .toList();
    }

    public Optional<Dosing> findDosingSystemById(Long id) {
        return this.dosingRepository.findById(id)
            .map(Dosing::new);
    }

    public Dosing createDosingSystem(Dosing dosing) {
        return new Dosing(this.dosingRepository.saveAndFlush(new DosingEntity(dosing)));
    }

    public Dosing updateDosingSystem(Long id, Dosing dosing) {
        Optional<Dosing> existingElement = this.dosingRepository.findById(id)
            .map(Dosing::new);

        if (existingElement.isPresent()) {
            Dosing updatedElement = existingElement.get();

            updatedElement.setId(dosing.getId());
            updatedElement.setName(dosing.getName());
            updatedElement.setPin(dosing.getPin());
            updatedElement.setJack(dosing.getJack());
            updatedElement.setRegiments(dosing.getRegiments());

            return new Dosing(this.dosingRepository.saveAndFlush(new DosingEntity(updatedElement)));
        }
        else {
            throw new DosingNotFoundException("Couldn't find the dosing system entry you requested with id: " + id);
        }
    }

    public void deleteDosingSystem(Long id) {
        this.dosingRepository.deleteById(id);
    }

    public void calibrate(Long id) {
        /* TODO: Implement this method */

        /*
         * Concept:
         * This should help to calibrate the dosing system
         */
    }

    public void history(Long id) {
        /* TODO: Implement this method */

        /*
         * Concept:
         * This should return the usage history of the dosing system
         */
    }
}
