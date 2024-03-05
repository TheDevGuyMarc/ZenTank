package de.aquazen.backend.capability.controller;

import de.aquazen.backend.capability.domain.Capability;
import de.aquazen.backend.capability.service.CapabilityService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/capabilities")
public class CapabilityController {
    private final CapabilityService capabilityService;

    public CapabilityController(CapabilityService capabilityService) {
        this.capabilityService = capabilityService;
    }

    @GetMapping
    public List<CapabilityDTO> list() {
        return this.capabilityService.findAllCapabilties()
                .stream()
                .map(CapabilityDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public CapabilityDTO read(@PathVariable @Min(1) Long id) {
        return this.capabilityService.findCapabilityById(id)
                .map(CapabilityDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public CapabilityDTO create(@RequestBody @Valid @NotNull @NotEmpty Capability settings) {
        return new CapabilityDTO(this.capabilityService.createCapability(settings));
    }

    @PutMapping("/{id}")
    public CapabilityDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty Capability settings) {
        return new CapabilityDTO(this.capabilityService.updateCapability(id, settings));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.capabilityService.deleteCapability(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
