package de.aquazen.backend.waves.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WaveRepository extends JpaRepository<WaveEntity, Long> {
    Optional<WaveEntity> findById(Long id);
}
