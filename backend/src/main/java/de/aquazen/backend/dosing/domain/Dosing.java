package de.aquazen.backend.dosing.domain;

import de.aquazen.backend.dosing.repository.DosingEntity;
import de.aquazen.backend.drivers.domain.Pin;
import de.aquazen.backend.jacks.domain.Jack;
import de.aquazen.backend.regiment.domain.Regiment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Dosing {
    private Long id;
    private String name;
    private Pin pin;
    private Jack jack;
    private List<Regiment> regiments;

    public Dosing(DosingEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.pin = entity.getPin();
        this.jack = new Jack(entity.getJack());
        this.regiments = entity.getRegiments().stream().map(Regiment::new).toList();
    }
}
