package de.aquazen.backend.inlets.repository;

import de.aquazen.backend.drivers.domain.Pin;
import de.aquazen.backend.drivers.repository.DriverEntity;
import de.aquazen.backend.inlets.domain.Inlet;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "inlets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InletEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Pin pin;

    @Column
    private boolean reverse;

    @Column
    private boolean state;

    @ManyToOne
    @JoinColumn(name = "drivers_id", referencedColumnName = "id")
    private DriverEntity driver;

    /* TODO: Implement Equipment relation (Object) 1-1 */

    public InletEntity(Inlet entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.pin = entity.getPin();
        this.reverse = entity.isReverse();
        this.state = entity.isState();
        this.driver = new DriverEntity(entity.getDriver());
    }
}
