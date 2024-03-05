package de.aquazen.backend.inlets.controller;

import de.aquazen.backend.inlets.domain.Inlet;
import de.aquazen.backend.inlets.service.InletService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inlets")
public class InletController {
    private final InletService inletService;

    public InletController(InletService inletService) {
        this.inletService = inletService;
    }

    @GetMapping
    public List<InletDTO> list() {
        return this.inletService.findAllInlets()
                .stream()
                .map(InletDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public InletDTO read(@PathVariable @Min(1) Long id) {
        return this.inletService.findInletById(id)
                .map(InletDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public InletDTO create(@RequestBody @Valid @NotNull @NotEmpty Inlet inlet) {
        return new InletDTO(this.inletService.createInlet(inlet));
    }

    @PutMapping("/{id}")
    public InletDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty Inlet inlet) {
        return new InletDTO(this.inletService.updateInlet(id, inlet));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.inletService.deleteInlet(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
