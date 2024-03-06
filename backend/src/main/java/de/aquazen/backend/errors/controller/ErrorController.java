package de.aquazen.backend.errors.controller;

import de.aquazen.backend.errors.domain.Error;
import de.aquazen.backend.errors.service.ErrorService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/errors")
public class ErrorController {
    private final ErrorService errorService;

    public ErrorController(ErrorService errorService) {
        this.errorService = errorService;
    }

    @GetMapping
    public List<ErrorDTO> list() {
        return this.errorService.findAllErrors()
                .stream()
                .map(ErrorDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public ErrorDTO read(@PathVariable @Min(1) Long id) {
        return this.errorService.findErrorById(id)
                .map(ErrorDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public ErrorDTO create(@RequestBody @Valid @NotNull @NotEmpty Error error) {
        return new ErrorDTO(this.errorService.createError(error));
    }

    @PutMapping("/{id}")
    public ErrorDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty Error error) {
        return new ErrorDTO(this.errorService.updateError(id, error));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.errorService.deleteError(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
