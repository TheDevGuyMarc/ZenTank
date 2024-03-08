package de.aquazen.backend.dosing.controller;

import de.aquazen.backend.dosing.domain.Dosing;
import de.aquazen.backend.drivers.domain.Pin;
import de.aquazen.backend.jacks.controller.JackDTO;
import de.aquazen.backend.regiment.controller.RegimentDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class DosingDTO {
    private final Long id;
    private final String name;
    private final Pin pin;
    private final JackDTO jack;
    private final List<RegimentDTO> regiments;

    public DosingDTO(Dosing entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.pin = entity.getPin();
        this.jack = new JackDTO(entity.getJack());
        this.regiments = entity.getRegiments().stream().map(RegimentDTO::new).toList();
    }
}
