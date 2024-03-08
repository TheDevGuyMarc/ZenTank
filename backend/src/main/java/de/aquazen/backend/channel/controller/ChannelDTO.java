package de.aquazen.backend.channel.controller;

import de.aquazen.backend.channel.domain.Channel;
import de.aquazen.backend.drivers.domain.Pin;
import de.aquazen.backend.lighting.controller.LightingDTO;
import de.aquazen.backend.waves.controller.WaveDTO;
import lombok.Getter;

@Getter
public class ChannelDTO {
    private final Long id;
    private final String name;
    private final String color;
    private final boolean manual;
    private final int min;
    private final int max;
    private final boolean state;
    private final Pin pin;
    private final int value;
    private final String type;
    private final LightingDTO light;
    private final WaveDTO wave;

    public ChannelDTO(Channel entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.color = entity.getColor();
        this.manual = entity.isManual();
        this.min = entity.getMin();
        this.max = entity.getMax();
        this.state = entity.isState();
        this.pin = entity.getPin();
        this.value = entity.getValue();
        this.type = entity.getType();
        this.light = new LightingDTO(entity.getLight());
        this.wave = new WaveDTO(entity.getWave());
    }
}
