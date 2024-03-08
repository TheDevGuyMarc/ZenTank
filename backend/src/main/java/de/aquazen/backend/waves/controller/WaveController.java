package de.aquazen.backend.waves.controller;

import de.aquazen.backend.waves.domain.Wave;
import de.aquazen.backend.waves.service.WaveService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wave-systems")
public class WaveController {
    private final WaveService waveService;

    public WaveController(WaveService waveService) {
        this.waveService = waveService;
    }

    @GetMapping
    public List<WaveDTO> list() {
        return this.waveService.findAllWaves()
                .stream()
                .map(WaveDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public WaveDTO read(@PathVariable @Min(1) Long id) {
        return this.waveService.findWaveById(id)
                .map(WaveDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public WaveDTO create(@RequestBody @Valid @NotNull @NotEmpty Wave wave) {
        return new WaveDTO(this.waveService.createWave(wave));
    }

    @PutMapping("/{id}")
    public WaveDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty Wave wave) {
        return new WaveDTO(this.waveService.updateWave(id, wave));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.waveService.deleteWave(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
