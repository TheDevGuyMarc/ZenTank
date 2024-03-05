package de.aquazen.backend.settings.domain;

import de.aquazen.backend.settings.repository.SettingsEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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

    /* TODO: add relation to Capabilities */

    /* TODO: add relation to HealthCheck */

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
    }
}
