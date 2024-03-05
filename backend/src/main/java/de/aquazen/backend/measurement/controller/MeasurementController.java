package de.aquazen.backend.measurement.controller;

import de.aquazen.backend.measurement.domain.Measurement;
import de.aquazen.backend.measurement.service.MeasurementService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/measurements")
public class MeasurementController {
    private final MeasurementService measurementService;

    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @GetMapping
    public List<MeasurementDTO> list() {
        return this.measurementService.findAllMeasurements()
                .stream()
                .map(MeasurementDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public MeasurementDTO read(@PathVariable @Min(1) Long id) {
        return this.measurementService.findMeasurementById(id)
                .map(MeasurementDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public MeasurementDTO create(@RequestBody @Valid @NotNull @NotEmpty Measurement measurement) {
        return new MeasurementDTO(this.measurementService.createMeasurement(measurement));
    }

    @PutMapping("/{id}")
    public MeasurementDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty Measurement measurement) {
        return new MeasurementDTO(this.measurementService.updateMeasurement(id, measurement));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.measurementService.deleteMeasurement(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
