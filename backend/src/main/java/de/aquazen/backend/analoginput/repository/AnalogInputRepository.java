package de.aquazen.backend.analoginput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnalogInputRepository extends JpaRepository<AnalogInputEntity, Long> {
    Optional<AnalogInputEntity> findById(Long id);
}
