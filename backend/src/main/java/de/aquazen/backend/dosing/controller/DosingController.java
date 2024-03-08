package de.aquazen.backend.dosing.controller;

import de.aquazen.backend.dosing.domain.Dosing;
import de.aquazen.backend.dosing.service.DosingService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dosing-systems")
public class DosingController {
    private final DosingService dosingService;

    public DosingController(DosingService dosingService) {
        this.dosingService = dosingService;
    }

    @GetMapping
    public List<DosingDTO> list() {
        return this.dosingService.findAllDosingSystems()
                .stream()
                .map(DosingDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public DosingDTO read(@PathVariable @Min(1) Long id) {
        return this.dosingService.findDosingSystemById(id)
                .map(DosingDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public DosingDTO create(@RequestBody @Valid @NotNull @NotEmpty Dosing dosing) {
        return new DosingDTO(this.dosingService.createDosingSystem(dosing));
    }

    @PutMapping("/{id}")
    public DosingDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty Dosing dosing) {
        return new DosingDTO(this.dosingService.updateDosingSystem(id, dosing));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.dosingService.deleteDosingSystem(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/calibrate/{id}")
    public ResponseEntity<Void> calibrate(@PathVariable @Min(1) Long id) {
        this.dosingService.calibrate(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/history/{id}")
    public ResponseEntity<Void> history(@PathVariable @Min(1) Long id) {
        this.dosingService.history(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
