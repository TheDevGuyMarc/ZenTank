package de.aquazen.backend.channel.domain;

import de.aquazen.backend.channel.repository.ChannelEntity;
import de.aquazen.backend.drivers.domain.Pin;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Channel {
    private Long id;
    private String name;
    private String color;
    private boolean manual;
    private int min;
    private int max;
    private boolean state;
    private Pin pin;
    private int value;
    private String type;

    public Channel(ChannelEntity entity) {
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
    }
}
