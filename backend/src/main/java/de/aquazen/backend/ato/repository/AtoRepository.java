package de.aquazen.backend.ato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AtoRepository extends JpaRepository<AtoEntity, Long> {
    Optional<AtoEntity> findById(Long id);
}
