package de.aquazen.backend.jacks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JackRepository extends JpaRepository<JackEntity, Long> {
    Optional<JackEntity> findById(Long id);
}
