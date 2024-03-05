package de.aquazen.backend.settings.controller;

import de.aquazen.backend.settings.domain.Settings;
import de.aquazen.backend.settings.service.SettingsService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/settings")
public class SettingsController {
    private final SettingsService settingsService;

    public SettingsController(SettingsService settingsService) {
        this.settingsService = settingsService;
    }

    @GetMapping
    public List<SettingsDTO> list() {
        return this.settingsService.findAllSettings()
                .stream()
                .map(SettingsDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public SettingsDTO read(@PathVariable @Min(1) Long id) {
        return this.settingsService.findSettingById(id)
                .map(SettingsDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public SettingsDTO create(@RequestBody @Valid @NotNull @NotEmpty Settings settings) {
        return new SettingsDTO(this.settingsService.createSetting(settings));
    }

    @PutMapping("/{id}")
    public SettingsDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty Settings settings) {
        return new SettingsDTO(this.settingsService.updateSetting(id, settings));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.settingsService.deleteSetting(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
