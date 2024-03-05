package de.aquazen.backend.steps.controller;

import de.aquazen.backend.steps.domain.Step;
import de.aquazen.backend.steps.service.StepService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/steps")
public class StepController {
    private final StepService stepService;

    public StepController(StepService stepService) {
        this.stepService = stepService;
    }

    @GetMapping
    public List<StepDTO> list() {
        return this.stepService.findAllSteps()
                .stream()
                .map(StepDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public StepDTO read(@PathVariable @Min(1) Long id) {
        return this.stepService.findStepById(id)
                .map(StepDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public StepDTO create(@RequestBody @Valid @NotNull @NotEmpty Step step) {
        return new StepDTO(this.stepService.createStep(step));
    }

    @PutMapping("/{id}")
    public StepDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty Step step) {
        return new StepDTO(this.stepService.updateStep(id, step));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.stepService.deleteStep(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
