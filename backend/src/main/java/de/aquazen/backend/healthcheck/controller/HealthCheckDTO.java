package de.aquazen.backend.healthcheck.controller;

import de.aquazen.backend.healthcheck.domain.HealthCheck;
import de.aquazen.backend.settings.controller.SettingsDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HealthCheckDTO {
    private final Long id;
    private final boolean enabled;
    private final double max_cpu;
    private final double max_memory;
    private final SettingsDTO setting;

    public HealthCheckDTO(HealthCheck entity) {
        this.id = entity.getId();
        this.enabled = entity.isEnabled();
        this.max_cpu = entity.getMax_cpu();
        this.max_memory = entity.getMax_memory();
        this.setting = new SettingsDTO(entity.getSetting());
    }
}
