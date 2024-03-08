package de.aquazen.backend.waves.controller;

import de.aquazen.backend.channel.controller.ChannelDTO;
import de.aquazen.backend.jacks.controller.JackDTO;
import de.aquazen.backend.waves.domain.Wave;
import lombok.Getter;

import java.util.List;

@Getter
public class WaveDTO {
    private final Long id;
    private final String name;
    private final boolean state;
    private final JackDTO jack;
    private final List<ChannelDTO> channels;

    public WaveDTO(Wave entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.state = entity.isState();
        this.jack = new JackDTO(entity.getJack());
        this.channels = entity.getChannels().stream().map(ChannelDTO::new).toList();
    }
}
