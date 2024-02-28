package de.aquazen.backend.inlets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InletRepository extends JpaRepository<InletEntity, Long> {
    Optional<InletEntity> findById(Long id);
}
