package de.aquazen.backend.outlets.service;

import de.aquazen.backend.outlets.domain.Outlet;
import de.aquazen.backend.outlets.exception.OutletNotFoundException;
import de.aquazen.backend.outlets.repository.OutletEntity;
import de.aquazen.backend.outlets.repository.OutletRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OutletService {
    private final OutletRepository outletRepository;

    public OutletService(OutletRepository outletRepository) {
        this.outletRepository = outletRepository;
    }

    public List<Outlet> findAllOutlets() {
        return this.outletRepository.findAll()
            .stream()
            .map(Outlet::new)
            .toList();
    }

    public Optional<Outlet> findOutletById(Long id) {
        return this.outletRepository.findById(id)
            .map(Outlet::new);
    }

    public Outlet createOutlet(Outlet outlet) {
        return new Outlet(this.outletRepository.saveAndFlush(new OutletEntity(outlet)));
    }

    public Outlet updateOutlet(Long id, Outlet outlet) {
        Optional<Outlet> existingElement = this.outletRepository.findById(id).map(Outlet::new);

        if (existingElement.isPresent()) {
            Outlet updatedElement = existingElement.get();

            updatedElement.setId(outlet.getId());
            updatedElement.setName(outlet.getName());
            updatedElement.setPin(outlet.getPin());
            updatedElement.setReverse(outlet.isReverse());
            updatedElement.setState(outlet.isState());
            updatedElement.setDriver(outlet.getDriver());
            updatedElement.setEquipment(outlet.getEquipment());

            return new Outlet(this.outletRepository.saveAndFlush(new OutletEntity(updatedElement)));
        }
        else {
            throw new OutletNotFoundException("Couldn't find the outlet entry you requested with id: " + id);
        }
    }

    public void deleteOutlet(Long id) {
        this.outletRepository.deleteById(id);
    }

    public void on() {
        /* TODO: Implement this method */

        /*
         * Concept:
         * This should set the object state to true after that it should set the GPIO Pin State to HIGH (DigitalOutput)
         */
    }

    public void off() {
        /* TODO: Implement this method */

        /*
         * Concept:
         * This should set the object state to true after that it should set the GPIO Pin State to LOW (DigitalOutput)
         */
    }

    public void reverse() {
        /* TODO: Implement this method */

        /*
         * Concept:
         * This should reverse the signal in theory (to help pumps pull and push)
         */
    }
}
