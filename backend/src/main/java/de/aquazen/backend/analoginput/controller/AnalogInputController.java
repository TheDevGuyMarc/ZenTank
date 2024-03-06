package de.aquazen.backend.analoginput.controller;

import de.aquazen.backend.analoginput.domain.AnalogInput;
import de.aquazen.backend.analoginput.service.AnalogInputService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/analog-inputs")
public class AnalogInputController {
    private final AnalogInputService analogInputService;

    public AnalogInputController(AnalogInputService analogInputService) {
        this.analogInputService = analogInputService;
    }

    @GetMapping
    public List<AnalogInputDTO> list() {
        return this.analogInputService.findAllAnalogInputs()
                .stream()
                .map(AnalogInputDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public AnalogInputDTO read(@PathVariable @Min(1) Long id) {
        return this.analogInputService.findAnalogInputById(id)
                .map(AnalogInputDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public AnalogInputDTO create(@RequestBody @Valid @NotNull @NotEmpty AnalogInput input) {
        return new AnalogInputDTO(this.analogInputService.createAnalogInput(input));
    }

    @PutMapping("/{id}")
    public AnalogInputDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty AnalogInput input) {
        return new AnalogInputDTO(this.analogInputService.updateAnalogInput(id, input));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.analogInputService.deleteAnalogInput(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Void> readData(@PathVariable @Min(1) Long id) {
        this.analogInputService.readData(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
