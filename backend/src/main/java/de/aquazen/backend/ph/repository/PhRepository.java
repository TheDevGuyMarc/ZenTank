package de.aquazen.backend.ph.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PhRepository extends JpaRepository<PhEntity, Long> {
    Optional<PhEntity> findById(Long id);
}
