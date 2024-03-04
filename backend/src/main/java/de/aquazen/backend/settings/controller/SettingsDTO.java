package de.aquazen.backend.settings.controller;

import de.aquazen.backend.settings.domain.Settings;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SettingsDTO {
    private final Long id;
    private final String name;
    private final String address;
    private final boolean display;
    private final boolean https;
    private final String networkInterface;
    private final boolean notifications;
    private final boolean pprof;
    private final boolean prometheus;
    private final int rpi_pwm_freq;

    /* TODO: add relation to Capabilities */

    /* TODO: add relation to HealthCheck */

    public SettingsDTO(Settings entity) {
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
