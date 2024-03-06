package de.aquazen.backend.equipment.controller;

import de.aquazen.backend.equipment.domain.Equipment;
import de.aquazen.backend.equipment.service.EquipmentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipments")
public class EquipmentController {
    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping
    public List<EquipmentDTO> list() {
        return this.equipmentService.findAllEquipments()
                .stream()
                .map(EquipmentDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public EquipmentDTO read(@PathVariable @Min(1) Long id) {
        return this.equipmentService.findEquipmentById(id)
                .map(EquipmentDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public EquipmentDTO create(@RequestBody @Valid @NotNull @NotEmpty Equipment equipment) {
        return new EquipmentDTO(this.equipmentService.createEquipment(equipment));
    }

    @PutMapping("/{id}")
    public EquipmentDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty Equipment equipment) {
        return new EquipmentDTO(this.equipmentService.updateEquipment(id, equipment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.equipmentService.deleteEquipment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/on/{id}")
    public ResponseEntity<Void> on(@PathVariable @Min(1) Long id) {
        this.equipmentService.on(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/off/{id}")
    public ResponseEntity<Void> off(@PathVariable @Min(1) Long id) {
        this.equipmentService.off(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/blink/{id}")
    public ResponseEntity<Void> blink(@PathVariable @Min(1) Long id) {
        this.equipmentService.blink(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/history/{id}")
    public ResponseEntity<Void> history(@PathVariable @Min(1) Long id) {
        this.equipmentService.history(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
