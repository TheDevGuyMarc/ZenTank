package de.aquazen.backend.misting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MistingRepository extends JpaRepository<MistingEntity, Long> {
    Optional<MistingEntity> findById(Long id);
}
