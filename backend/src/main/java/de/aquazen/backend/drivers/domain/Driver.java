package de.aquazen.backend.drivers.domain;

import de.aquazen.backend.drivers.repository.DriverEntity;
import de.aquazen.backend.inlets.domain.Inlet;
import de.aquazen.backend.jacks.domain.Jack;
import de.aquazen.backend.outlets.domain.Outlet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Driver {
    private Long id;
    private String name;
    private List<Pin> pinMap;
    private String type;
    private List<Outlet> outlets;
    private List<Inlet> inlets;
    private List<Jack> jacks;

    public Driver(DriverEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.pinMap = entity.getPinMap();
        this.type = entity.getType();
        this.outlets = entity.getOutlets().stream().map(Outlet::new).toList();
        this.inlets = entity.getInlets().stream().map(Inlet::new).toList();
        this.jacks = entity.getJacks().stream().map(Jack::new).toList();
    }
}
