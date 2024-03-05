package de.aquazen.backend.healthcheck.service;

import de.aquazen.backend.healthcheck.domain.HealthCheck;
import de.aquazen.backend.healthcheck.exception.HealthCheckNotFoundException;
import de.aquazen.backend.healthcheck.repository.HealthCheckEntity;
import de.aquazen.backend.healthcheck.repository.HealthCheckRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HealthCheckService {
    private final HealthCheckRepository healthCheckRepository;

    public HealthCheckService(HealthCheckRepository healthCheckRepository) {
        this.healthCheckRepository = healthCheckRepository;
    }

    public List<HealthCheck> findAllHealthChecks() {
        return this.healthCheckRepository.findAll()
                .stream()
                .map(HealthCheck::new)
                .toList();
    }

    public Optional<HealthCheck> findHealthCheckById(Long id) {
        return this.healthCheckRepository.findById(id)
                .map(HealthCheck::new);
    }

    public HealthCheck createHealthCheck(HealthCheck healthCheck) {
        return new HealthCheck(this.healthCheckRepository.saveAndFlush(new HealthCheckEntity(healthCheck)));
    }

    public HealthCheck updateHealthCheck(Long id, HealthCheck healthCheck) {
        Optional<HealthCheck> existingElement = this.healthCheckRepository.findById(id)
                .map(HealthCheck::new);

        if (existingElement.isPresent()) {
            HealthCheck updatedElement = existingElement.get();

            updatedElement.setId(healthCheck.getId());
            updatedElement.setEnabled(healthCheck.isEnabled());
            updatedElement.setMax_cpu(healthCheck.getMax_cpu());
            updatedElement.setMax_memory(healthCheck.getMax_memory());
            updatedElement.setSetting(healthCheck.getSetting());

            return new HealthCheck(this.healthCheckRepository.saveAndFlush(new HealthCheckEntity(updatedElement)));
        }
        else {
            throw new HealthCheckNotFoundException("Couldn't find the health-check entry you requested with id: " + id);
        }
    }

    public void deleteHealthCheck(Long id) {
        this.healthCheckRepository.deleteById(id);
    }
}
