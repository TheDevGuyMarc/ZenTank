package de.aquazen.backend.timer.controller;

import de.aquazen.backend.timer.domain.Timer;
import de.aquazen.backend.timer.service.TimerService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timers")
public class TimerController {
    private final TimerService timerService;

    public TimerController(TimerService timerService) {
        this.timerService = timerService;
    }

    @GetMapping
    public List<TimerDTO> list() {
        return this.timerService.findAllTimers()
                .stream()
                .map(TimerDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public TimerDTO read(@PathVariable @Min(1) Long id) {
        return this.timerService.findTimerById(id)
                .map(TimerDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public TimerDTO create(@RequestBody @Valid @NotNull @NotEmpty Timer timer) {
        return new TimerDTO(this.timerService.createTimer(timer));
    }

    @PutMapping("/{id}")
    public TimerDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty Timer timer) {
        return new TimerDTO(this.timerService.updateTimer(id, timer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.timerService.deleteTimer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
