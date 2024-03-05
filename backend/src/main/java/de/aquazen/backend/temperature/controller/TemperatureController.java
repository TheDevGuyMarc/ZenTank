package de.aquazen.backend.temperature.controller;

import de.aquazen.backend.temperature.domain.Temperature;
import de.aquazen.backend.temperature.service.TemperatureService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/temperature-sensors")
public class TemperatureController {
    private final TemperatureService temperatureService;

    public TemperatureController(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    @GetMapping
    public List<TemperatureDTO> list() {
        return this.temperatureService.findAllTemperatureProbes()
                .stream()
                .map(TemperatureDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public TemperatureDTO read(@PathVariable @Min(1) Long id) {
        return this.temperatureService.findTemperatureProbeById(id)
                .map(TemperatureDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public TemperatureDTO create(@RequestBody @Valid @NotNull @NotEmpty Temperature temperature) {
        return new TemperatureDTO(this.temperatureService.createTemperatureProbe(temperature));
    }

    @PutMapping("/{id}")
    public TemperatureDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty Temperature temperature) {
        return new TemperatureDTO(this.temperatureService.updateTemperatureProbe(id, temperature));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.temperatureService.deleteTemperatureProbe(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
