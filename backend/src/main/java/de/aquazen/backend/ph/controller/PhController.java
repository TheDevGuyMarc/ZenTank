package de.aquazen.backend.ph.controller;

import de.aquazen.backend.ph.domain.Ph;
import de.aquazen.backend.ph.service.PhService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ph-sensors")
public class PhController {
    private final PhService phService;

    public PhController(PhService phService) {
        this.phService = phService;
    }

    @GetMapping
    public List<PhDTO> list() {
        return this.phService.findAllPhProbes()
                .stream()
                .map(PhDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public PhDTO read(@PathVariable @Min(1) Long id) {
        return this.phService.findPhProbeById(id)
                .map(PhDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public PhDTO create(@RequestBody @Valid @NotNull @NotEmpty Ph ph) {
        return new PhDTO(this.phService.createPhProbe(ph));
    }

    @PutMapping("/{id}")
    public PhDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty Ph ph) {
        return new PhDTO(this.phService.updatePhProbe(id, ph));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.phService.deletePhProbe(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
