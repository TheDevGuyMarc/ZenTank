package de.aquazen.backend.macros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MacroRepository extends JpaRepository<MacroEntity, Long> {
    Optional<MacroEntity> findById(Long id);
}
