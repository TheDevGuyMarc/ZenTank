package de.aquazen.backend.capability.repository;

import de.aquazen.backend.capability.domain.Capability;
import de.aquazen.backend.settings.domain.Settings;
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


  public CapabilityEntity(Capability entity) {
    this.id = entity.getId();
    this.name = entity.getName();
    this.enabled = entity.isEnabled();
  }
}
