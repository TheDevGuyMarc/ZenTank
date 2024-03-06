package de.aquazen.backend.drivers.controller;

import de.aquazen.backend.drivers.domain.Driver;
import de.aquazen.backend.drivers.domain.Pin;
import de.aquazen.backend.inlets.controller.InletDTO;
import de.aquazen.backend.outlets.controller.OutletDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class DriverDTO {
    private final Long id;
    private final String name;
    private final List<Pin> pinMap;
    private final String type;
    private final List<OutletDTO> outlets;
    private final List<InletDTO> inlets;

    public DriverDTO(Driver entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.pinMap = entity.getPinMap();
        this.type = entity.getType();
        this.outlets = entity.getOutlets().stream().map(OutletDTO::new).toList();
        this.inlets = entity.getInlets().stream().map(InletDTO::new).toList();
    }
}
