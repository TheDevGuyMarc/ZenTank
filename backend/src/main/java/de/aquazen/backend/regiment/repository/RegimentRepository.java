package de.aquazen.backend.regiment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegimentRepository extends JpaRepository<RegimentEntity, Long> {
    Optional<RegimentEntity> findById(Long id);
}
