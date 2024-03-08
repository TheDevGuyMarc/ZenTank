package de.aquazen.backend.lighting.controller;

import de.aquazen.backend.channel.controller.ChannelDTO;
import de.aquazen.backend.jacks.controller.JackDTO;
import de.aquazen.backend.lighting.domain.Lighting;
import lombok.Getter;

import java.util.List;

@Getter
public class LightingDTO {
    private final Long id;
    private final String name;
    private final boolean state;
    private final JackDTO jack;
    private final List<ChannelDTO> channels;

    public LightingDTO(Lighting entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.state = entity.isState();
        this.jack = new JackDTO(entity.getJack());
        this.channels = entity.getChannels().stream().map(ChannelDTO::new).toList();
    }
}
