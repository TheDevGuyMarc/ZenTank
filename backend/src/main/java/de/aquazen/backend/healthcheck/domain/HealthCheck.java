package de.aquazen.backend.healthcheck.domain;

import de.aquazen.backend.healthcheck.repository.HealthCheckEntity;
import de.aquazen.backend.settings.domain.Settings;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class HealthCheck {
    private Long id;
    private boolean enabled;
    private double max_cpu;
    private double max_memory;
    private Settings setting;

    public HealthCheck(HealthCheckEntity entity) {
        this.id = entity.getId();
        this.enabled = entity.isEnabled();
        this.max_cpu = entity.getMax_cpu();
        this.max_memory = entity.getMax_memory();
        this.setting = new Settings(entity.getSetting());
    }
}
