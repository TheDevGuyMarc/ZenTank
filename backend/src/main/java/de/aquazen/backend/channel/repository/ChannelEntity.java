package de.aquazen.backend.channel.repository;

import de.aquazen.backend.channel.domain.Channel;
import de.aquazen.backend.drivers.domain.Pin;
import de.aquazen.backend.lighting.repository.LightingEntity;
import de.aquazen.backend.waves.repository.WaveEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "channels")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChannelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String color;

    @Column
    private boolean manual;

    @Column
    private int min;

    @Column
    private int max;

    @Column
    private boolean state;

    @Column
    private Pin pin;

    @Column
    private int value;

    @Column
    private String type;

    @ManyToOne
    @JoinColumn(name = "channel_id", referencedColumnName = "id")
    private LightingEntity light;

    @ManyToOne
    @JoinColumn(name = "channel_id", referencedColumnName = "id")
    private WaveEntity wave;


    public ChannelEntity(Channel entity) {
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
        this.light = new LightingEntity(entity.getLight());
        this.wave = new WaveEntity(entity.getWave());
    }
}
