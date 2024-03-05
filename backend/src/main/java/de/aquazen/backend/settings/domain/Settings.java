package de.aquazen.backend.settings.domain;

import de.aquazen.backend.capability.domain.Capability;
import de.aquazen.backend.healthcheck.domain.HealthCheck;
import de.aquazen.backend.settings.repository.SettingsEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Settings {
    private Long id;
    private String name;
    private String address;
    private boolean display;
    private boolean https;
    private String networkInterface;
    private boolean notifications;
    private boolean pprof;
    private boolean prometheus;
    private int rpi_pwm_freq;
    private List<Capability> capabilities;
    private HealthCheck healthCheck;

    public Settings(SettingsEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.address = entity.getAddress();
        this.display = entity.isNotifications();
        this.https = entity.isHttps();
        this.networkInterface = entity.getNetworkInterface();
        this.notifications = entity.isNotifications();
        this.pprof = entity.isPprof();
        this.prometheus = entity.isPrometheus();
        this.rpi_pwm_freq = entity.getRpi_pwm_freq();
        this.capabilities = entity.getCapabilities().stream().map(Capability::new).toList();
        this.healthCheck = new HealthCheck(entity.getHealthCheck());
    }
}
