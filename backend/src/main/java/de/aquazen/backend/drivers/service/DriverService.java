package de.aquazen.backend.drivers.service;

import de.aquazen.backend.drivers.domain.Driver;
import de.aquazen.backend.drivers.exception.DriverNotFoundException;
import de.aquazen.backend.drivers.repository.DriverEntity;
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
        return this.driverRepository.findAll()
                .stream()
                .map(Driver::new)
                .toList();
    }

    public Optional<Driver> findDriverById(Long id) {
        return this.driverRepository.findById(id)
                .map(Driver::new);
    }

    public Driver createDriver(Driver driver) {
        return new Driver(this.driverRepository.saveAndFlush(new DriverEntity(driver)));
    }

    public Driver updateDriver(Long id, Driver driver) {
        Optional<Driver> existingElement = this.driverRepository.findById(id)
                .map(Driver::new);

        if (existingElement.isPresent()) {
            Driver updatedElement = existingElement.get();

            updatedElement.setId(driver.getId());
            updatedElement.setName(driver.getName());
            updatedElement.setPinMap(driver.getPinMap());
            updatedElement.setType(driver.getType());

            return new Driver(this.driverRepository.saveAndFlush(new DriverEntity(updatedElement)));
        }
        else {
            throw new DriverNotFoundException("Couldn't find the driver entry you requested with id: " + id);
        }
    }

    public void deleteDriver(Long id) {
        this.driverRepository.deleteById(id);
    }
}
