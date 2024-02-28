package de.aquazen.backend.lighting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LightingRepository extends JpaRepository<LightingEntity, Long> {
    Optional<LightingEntity> findById(Long id);
}
