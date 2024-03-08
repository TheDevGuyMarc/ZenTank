package de.aquazen.backend.waves.domain;

import de.aquazen.backend.channel.domain.Channel;
import de.aquazen.backend.jacks.domain.Jack;
import de.aquazen.backend.waves.repository.WaveEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Wave {
    private Long id;
    private String name;
    private boolean state;
    private Jack jack;
    private List<Channel> channels;

    public Wave(WaveEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.state = entity.isState();
        this.jack = new Jack(entity.getJack());
        this.channels = entity.getChannels().stream().map(Channel::new).toList();
    }
}
