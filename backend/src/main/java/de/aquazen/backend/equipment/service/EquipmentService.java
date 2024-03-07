package de.aquazen.backend.equipment.service;

import de.aquazen.backend.equipment.domain.Equipment;
import de.aquazen.backend.equipment.exception.EquipmentNotFoundException;
import de.aquazen.backend.equipment.repository.EquipmentEntity;
import de.aquazen.backend.equipment.repository.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {
    private final EquipmentRepository equipmentRepository;

    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public List<Equipment> findAllEquipments() {
        return this.equipmentRepository.findAll()
            .stream()
            .map(Equipment::new)
            .toList();
    }

    public Optional<Equipment> findEquipmentById(Long id) {
        return this.equipmentRepository.findById(id)
            .map(Equipment::new);
    }

    public Equipment createEquipment(Equipment equipment) {
        return new Equipment(this.equipmentRepository.saveAndFlush(new EquipmentEntity(equipment)));
    }

    public Equipment updateEquipment(Long id, Equipment equipment) {
        Optional<Equipment> existingElement = this.equipmentRepository.findById(id)
            .map(Equipment::new);

        if (existingElement.isPresent()) {
            Equipment updatedElement = existingElement.get();

            updatedElement.setId(equipment.getId());
            updatedElement.setName(equipment.getName());
            updatedElement.setState(equipment.isState());
            updatedElement.setType(equipment.getType());
            updatedElement.setOutlet(equipment.getOutlet());
            updatedElement.setCooler(equipment.getCooler());
            updatedElement.setHeater(equipment.getHeater());

            return new Equipment(this.equipmentRepository.saveAndFlush(new EquipmentEntity(updatedElement)));
        }
        else {
            throw new EquipmentNotFoundException("Couldn't find the equipment entry you requested with id: " + id);
        }
    }

    public void deleteEquipment(Long id) {
        this.equipmentRepository.deleteById(id);
    }

    public void on(Long id) {
        /* TODO: Implement this method */

        /*
         * Concept:
         * This should toggle the Equipment to on
         */
    }

    public void off(Long id) {
        /* TODO: Implement this method */

        /*
         * Concept:
         * This should toggle the Equipment to off
         */
    }

    public void blink(Long id) {
        /* TODO: Implement this method */

        /*
         * Concept:
         * This should toggle the Equipment between on and off in an interval
         */
    }

    public void history(Long id) {
        /* TODO: Implement this method */

        /*
         * Concept:
         * This should show the usage and state history of the specified Equipment
         */
    }
}
