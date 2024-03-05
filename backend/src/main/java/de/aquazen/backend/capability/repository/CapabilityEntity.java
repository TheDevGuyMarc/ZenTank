package de.aquazen.backend.capability.repository;

import de.aquazen.backend.capability.domain.Capability;
import de.aquazen.backend.settings.domain.Settings;
import de.aquazen.backend.settings.repository.SettingsEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "capabilities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CapabilityEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String name;

  @Column
  private boolean enabled;

  @ManyToOne
  @JoinColumn(name = "settings_id", referencedColumnName = "id")
  private SettingsEntity settings;

  public CapabilityEntity(Capability entity) {
    this.id = entity.getId();
    this.name = entity.getName();
    this.enabled = entity.isEnabled();
    this.settings = new SettingsEntity(entity.getSettings());
  }
}
