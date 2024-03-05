package de.aquazen.backend.drivers.service;

import de.aquazen.backend.drivers.domain.Driver;
import de.aquazen.backend.drivers.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {
    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public List<Driver> findAllDrivers() {

    }

    public Optional<Driver> findDriverById(Long id) {

    }

    public Driver createDriver(Driver driver) {

    }

    public Driver updateDriver(Long id, Driver driver) {

    }

    public void deleteDriver(Long id) {

    }
}
