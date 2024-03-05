package de.aquazen.backend.lighting.controller;

import de.aquazen.backend.lighting.domain.Lighting;
import de.aquazen.backend.lighting.service.LightingService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lights")
public class LightingController {
    private final LightingService lightingService;

    public LightingController(LightingService lightingService) {
        this.lightingService = lightingService;
    }

    @GetMapping
    public List<LightingDTO> list() {
        return this.lightingService.findAllLights()
                .stream()
                .map(LightingDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public LightingDTO read(@PathVariable @Min(1) Long id) {
        return this.lightingService.findLightById(id)
                .map(LightingDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public LightingDTO create(@RequestBody @Valid @NotNull @NotEmpty Lighting lighting) {
        return new LightingDTO(this.lightingService.createLight(lighting));
    }

    @PutMapping("/{id}")
    public LightingDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty Lighting lighting) {
        return new LightingDTO(this.lightingService.updateLight(id, lighting));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.lightingService.deleteLight(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
