package de.aquazen.backend.lighting.repository;

import de.aquazen.backend.channel.repository.ChannelEntity;
import de.aquazen.backend.jacks.repository.JackEntity;
import de.aquazen.backend.lighting.domain.Lighting;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "lights")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LightingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private boolean state;

    @OneToOne
    @JoinColumn(name = "jack_id")
    private JackEntity jack;

    @OneToMany(mappedBy = "light", cascade = CascadeType.ALL)
    private List<ChannelEntity> channels;

    public LightingEntity(Lighting entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.state = entity.isState();
        this.jack = new JackEntity(entity.getJack());
        this.channels = entity.getChannels().stream().map(ChannelEntity::new).toList();
    }
}
