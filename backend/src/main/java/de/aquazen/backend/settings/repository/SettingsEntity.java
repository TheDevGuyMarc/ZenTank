package de.aquazen.backend.settings.repository;

import de.aquazen.backend.settings.domain.Settings;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "settings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SettingsEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String name;

  @Column
  private String address;

  @Column
  private boolean display;

  @Column
  private boolean https;

  @Column
  private String networkInterface;

  @Column
  private boolean notifications;

  @Column
  private boolean pprof;

  @Column
  private boolean prometheus;

  @Column
  private int rpi_pwm_freq;

  /* TODO: add relation to Capabilities */

  /* TODO: add relation to HealthCheck */

  public SettingsEntity(Settings entity) {
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
