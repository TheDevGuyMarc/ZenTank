package de.aquazen.backend.drivers.controller;

import de.aquazen.backend.drivers.domain.Driver;
import de.aquazen.backend.drivers.service.DriverService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {
    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping
    public List<DriverDTO> list() {
        return this.driverService.findAllDrivers()
                .stream()
                .map(DriverDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public DriverDTO read(@PathVariable @Min(1) Long id) {
        return this.driverService.findDriverById(id)
                .map(DriverDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public DriverDTO create(@RequestBody @Valid @NotNull @NotEmpty Driver driver) {
        return new DriverDTO(this.driverService.createDriver(driver));
    }

    @PutMapping("/{id}")
    public DriverDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty Driver driver) {
        return new DriverDTO(this.driverService.updateDriver(id, driver));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.driverService.deleteDriver(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
