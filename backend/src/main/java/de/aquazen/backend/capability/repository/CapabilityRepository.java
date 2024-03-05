package de.aquazen.backend.capability.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CapabilityRepository extends JpaRepository<CapabilityEntity, Long> {
    Optional<CapabilityEntity> findById(Long id);
}
