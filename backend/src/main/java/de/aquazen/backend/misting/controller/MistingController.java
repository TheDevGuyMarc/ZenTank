package de.aquazen.backend.misting.controller;

import de.aquazen.backend.misting.domain.Misting;
import de.aquazen.backend.misting.service.MistingService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/misting-systems")
public class MistingController {
    private final MistingService mistingService;

    public MistingController(MistingService mistingService) {
        this.mistingService = mistingService;
    }

    @GetMapping
    public List<MistingDTO> list() {
        return this.mistingService.findAllMistings()
                .stream()
                .map(MistingDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public MistingDTO read(@PathVariable @Min(1) Long id) {
        return this.mistingService.findMistingById(id)
                .map(MistingDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public MistingDTO create(@RequestBody @Valid @NotNull @NotEmpty Misting misting) {
        return new MistingDTO(this.mistingService.createMisting(misting));
    }

    @PutMapping("/{id}")
    public MistingDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty Misting misting) {
        return new MistingDTO(this.mistingService.updateMisting(id, misting));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.mistingService.deleteMisting(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
