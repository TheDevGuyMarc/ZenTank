package de.aquazen.backend.temperature.repository;

import de.aquazen.backend.equipment.repository.EquipmentEntity;
import de.aquazen.backend.temperature.domain.Temperature;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Columns;

@Entity
@Table(name = "temperature_probes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TemperatureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private boolean fahrenheit;

    @Column
    private boolean alerts;

    @Column
    private int min;

    @Column
    private int max;

    @Column
    private double heaterThreshold;

    @Column
    private double coolerThreshold;

    @Column
    private int checkFrequency;

    @Column
    private String sensorState;

    @OneToOne(mappedBy = "cooler")
    private EquipmentEntity cooler;

    @OneToOne(mappedBy = "heater")
    private EquipmentEntity heater;

    /* TODO: Implement Sensor relation */

    public TemperatureEntity(Temperature entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.fahrenheit = entity.isFahrenheit();
        this.alerts = entity.isAlerts();
        this.min = entity.getMin();
        this.max = entity.getMax();
        this.heaterThreshold = entity.getHeaterThreshold();
        this.coolerThreshold = entity.getCoolerThreshold();
        this.checkFrequency = entity.getCheckFrequency();
        this.sensorState = entity.getSensorState();
        this.cooler = new EquipmentEntity(entity.getCooler());
        this.heater = new EquipmentEntity(entity.getHeater());
    }
}
