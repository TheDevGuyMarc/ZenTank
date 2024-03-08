package de.aquazen.backend.regiment.controller;

import de.aquazen.backend.regiment.domain.Regiment;
import de.aquazen.backend.regiment.service.RegimentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/regiments")
public class RegimentController {
    private final RegimentService regimentService;

    public RegimentController(RegimentService regimentService) {
        this.regimentService = regimentService;
    }

    @GetMapping
    public List<RegimentDTO> list() {
        return this.regimentService.findAllRegiments()
                .stream()
                .map(RegimentDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public RegimentDTO read(@PathVariable @Min(1) Long id) {
        return this.regimentService.findRegimentById(id)
                .map(RegimentDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public RegimentDTO create(@RequestBody @Valid @NotNull @NotEmpty Regiment regiment) {
        return new RegimentDTO(this.regimentService.createRegiment(regiment));
    }

    @PutMapping("/{id}")
    public RegimentDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty Regiment regiment) {
        return new RegimentDTO(this.regimentService.updateRegiment(id, regiment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.regimentService.deleteRegiment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
