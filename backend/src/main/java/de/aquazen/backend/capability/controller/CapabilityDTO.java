package de.aquazen.backend.capability.controller;

import de.aquazen.backend.capability.domain.Capability;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CapabilityDTO {
    private final Long id;
    private final String name;
    private final boolean enabled;

    public CapabilityDTO(Capability entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.enabled = entity.isEnabled();
    }
}
