package de.aquazen.backend.macros.controller;

import de.aquazen.backend.macros.domain.Macro;
import de.aquazen.backend.macros.service.MacroService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/macros")
public class MacroController {
    private final MacroService macroService;

    public MacroController(MacroService macroService) {
        this.macroService = macroService;
    }

    @GetMapping
    public List<MacroDTO> list() {
        return this.macroService.findAllMacros()
                .stream()
                .map(MacroDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public MacroDTO read(@PathVariable @Min(1) Long id) {
        return this.macroService.findMacroById(id)
                .map(MacroDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public MacroDTO create(@RequestBody @Valid @NotNull @NotEmpty Macro macro) {
        return new MacroDTO(this.macroService.createMacro(macro));
    }

    @PutMapping("/{id}")
    public MacroDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty Macro macro) {
        return new MacroDTO(this.macroService.updateMacro(id, macro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.macroService.deleteMacro(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
