package de.aquazen.backend.healthcheck.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HealthCheckRepository extends JpaRepository<HealthCheckEntity, Long> {
    Optional<HealthCheckEntity> findById(Long id);
}
