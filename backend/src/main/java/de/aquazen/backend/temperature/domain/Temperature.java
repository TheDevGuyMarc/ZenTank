package de.aquazen.backend.temperature.domain;

import de.aquazen.backend.equipment.domain.Equipment;
import de.aquazen.backend.temperature.repository.TemperatureEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Temperature {
    private Long id;
    private String name;
    private boolean fahrenheit;
    private boolean alerts;
    private int min;
    private int max;
    private double heaterThreshold;
    private double coolerThreshold;
    private int checkFrequency;
    private String sensorState;
    private Equipment cooler;
    private Equipment heater;

    /* TODO: Implement Sensor relation */

    public Temperature(TemperatureEntity entity) {
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
        this.cooler = new Equipment(entity.getCooler());
        this.heater = new Equipment(entity.getHeater());
    }
}
