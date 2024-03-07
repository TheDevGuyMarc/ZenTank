package de.aquazen.backend.ato.controller;

import de.aquazen.backend.ato.domain.Ato;
import de.aquazen.backend.ato.service.AtoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ato-systems")
public class AtoController {
    private final AtoService atoService;

    public AtoController(AtoService atoService) {
        this.atoService = atoService;
    }

    @GetMapping
    public List<AtoDTO> list() {
        return this.atoService.findAllAtos()
                .stream()
                .map(AtoDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public AtoDTO read(@PathVariable @Min(1) Long id) {
        return this.atoService.findAtoById(id)
                .map(AtoDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public AtoDTO create(@RequestBody @Valid @NotNull @NotEmpty Ato ato) {
        return new AtoDTO(this.atoService.createAto(ato));
    }

    @PutMapping("/{id}")
    public AtoDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty Ato ato) {
        return new AtoDTO(this.atoService.updateAto(id, ato));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.atoService.deleteAto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/history/{id}")
    public ResponseEntity<Void> history(@PathVariable @Min(1) Long id) {
        this.atoService.history(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
