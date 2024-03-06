package de.aquazen.backend.healthcheck.controller;

import de.aquazen.backend.healthcheck.domain.HealthCheck;
import de.aquazen.backend.healthcheck.service.HealthCheckService;
import de.aquazen.backend.settings.controller.SettingsDTO;
import de.aquazen.backend.settings.domain.Settings;
import de.aquazen.backend.settings.service.SettingsService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/health-checks")
public class HealthCheckController {
    private final HealthCheckService healthCheckService;

    public HealthCheckController(HealthCheckService healthCheckService) {
        this.healthCheckService = healthCheckService;
    }

    @GetMapping
    public List<HealthCheckDTO> list() {
        return this.healthCheckService.findAllHealthChecks()
                .stream()
                .map(HealthCheckDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public HealthCheckDTO read(@PathVariable @Min(1) Long id) {
        return this.healthCheckService.findHealthCheckById(id)
                .map(HealthCheckDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public HealthCheckDTO create(@RequestBody @Valid @NotNull @NotEmpty HealthCheck healthCheck) {
        return new HealthCheckDTO(this.healthCheckService.createHealthCheck(healthCheck));
    }

    @PutMapping("/{id}")
    public HealthCheckDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty HealthCheck healthCheck) {
        return new HealthCheckDTO(this.healthCheckService.updateHealthCheck(id, healthCheck));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.healthCheckService.deleteHealthCheck(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
