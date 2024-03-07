package de.aquazen.backend.temperature.controller;

import de.aquazen.backend.equipment.controller.EquipmentDTO;
import de.aquazen.backend.temperature.domain.Temperature;
import lombok.Getter;

@Getter
public class TemperatureDTO {
    private final Long id;
    private final String name;
    private final boolean fahrenheit;
    private final boolean alerts;
    private final int min;
    private final int max;
    private final double heaterThreshold;
    private final double coolerThreshold;
    private final int checkFrequency;
    private final String sensorState;
    private final EquipmentDTO cooler;
    private final EquipmentDTO heater;

    /* TODO: Implement Sensor relation */

    public TemperatureDTO(Temperature entity) {
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
        this.cooler = new EquipmentDTO(entity.getCooler());
        this.heater = new EquipmentDTO(entity.getHeater());
    }
}
