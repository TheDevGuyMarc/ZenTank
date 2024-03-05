package de.aquazen.backend.measurement.repository;

import de.aquazen.backend.measurement.repository.MeasurementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MeasurementRepository extends JpaRepository<MeasurementEntity, Long> {
    Optional<MeasurementEntity> findById(Long id);
}
