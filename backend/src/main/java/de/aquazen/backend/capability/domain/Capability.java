package de.aquazen.backend.capability.domain;

import de.aquazen.backend.capability.repository.CapabilityEntity;
import de.aquazen.backend.settings.domain.Settings;
import de.aquazen.backend.settings.repository.SettingsEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Capability {
    private Long id;
    private String name;
    private boolean enabled;
    private Settings settings;

    public Capability(CapabilityEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.enabled = entity.isEnabled();
        this.settings = new Settings(entity.getSettings());
    }
}
