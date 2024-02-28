package de.aquazen.backend.equipment.service;

import de.aquazen.backend.equipment.domain.Equipment;
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

    }

    public Optional<Equipment> findEquipmentById(Long id) {

    }

    public Equipment createEquipment(Equipment equipment) {

    }

    public Equipment updateEquipment(Long id, Equipment equipment) {

    }

    public void deleteEquipment(Long id) {

    }
}
