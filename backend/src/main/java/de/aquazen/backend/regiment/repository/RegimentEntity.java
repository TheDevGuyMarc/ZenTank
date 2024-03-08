package de.aquazen.backend.regiment.repository;

import de.aquazen.backend.dosing.repository.DosingEntity;
import de.aquazen.backend.regiment.domain.Regiment;
import de.aquazen.backend.waves.repository.WaveEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "regiments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegimentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private double duration;

    @Column
    private double speed;

    @Column
    private boolean state;

    /* TODO: implement timer relation */

    @ManyToOne
    @JoinColumn(name = "regiment_id", referencedColumnName = "id")
    private DosingEntity dosing;

    public RegimentEntity(Regiment entity) {
        this.id = entity.getId();
        this.duration = entity.getDuration();
        this.speed = entity.getSpeed();
        this.state = entity.isState();
        this.dosing = new DosingEntity(entity.getDosing());
    }
}
