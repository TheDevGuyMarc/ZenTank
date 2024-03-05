package de.aquazen.backend.healthcheck.repository;

import de.aquazen.backend.healthcheck.domain.HealthCheck;
import de.aquazen.backend.settings.repository.SettingsEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "health-checks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HealthCheckEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private boolean enabled;

  @Column
  private double max_cpu;

  @Column
  private double max_memory;

  @OneToOne
  @JoinColumn(name = "settings_id", referencedColumnName = "id")
  private SettingsEntity setting;


  public HealthCheckEntity(HealthCheck entity) {
    this.id = entity.getId();
    this.enabled = entity.isEnabled();
    this.max_cpu = entity.getMax_cpu();
    this.max_memory = entity.getMax_memory();
    this.setting = new SettingsEntity(entity.getSetting());
  }
}
