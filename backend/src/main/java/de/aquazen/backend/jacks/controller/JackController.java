package de.aquazen.backend.jacks.controller;

import de.aquazen.backend.jacks.domain.Jack;
import de.aquazen.backend.jacks.service.JackService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jacks")
public class JackController {
    private final JackService jackService;

    public JackController(JackService jackService) {
        this.jackService = jackService;
    }

    @GetMapping
    public List<JackDTO> list() {
        return this.jackService.findAllJacks()
                .stream()
                .map(JackDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public JackDTO read(@PathVariable @Min(1) Long id) {
        return this.jackService.findJackById(id)
                .map(JackDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public JackDTO create(@RequestBody @Valid @NotNull @NotEmpty Jack jack) {
        return new JackDTO(this.jackService.createJack(jack));
    }

    @PutMapping("/{id}")
    public JackDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty Jack jack) {
        return new JackDTO(this.jackService.updateJack(id, jack));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.jackService.deleteJack(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/stop/{id}")
    public ResponseEntity<Void> stop(@PathVariable @Min(1) Long id) {
        this.jackService.stop(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/pulse/{id}")
    public ResponseEntity<Void> pulse(@PathVariable @Min(1) Long id) {
        this.jackService.pulse(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/fade/{id}")
    public ResponseEntity<Void> fade(@PathVariable @Min(1) Long id) {
        this.jackService.fade(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/rampUp/{id}")
    public ResponseEntity<Void> ramUp(@PathVariable @Min(1) Long id) {
        this.jackService.ramUp(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/rampDown/{id}")
    public ResponseEntity<Void> rampDown(@PathVariable @Min(1) Long id) {
        this.jackService.rampDown(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
