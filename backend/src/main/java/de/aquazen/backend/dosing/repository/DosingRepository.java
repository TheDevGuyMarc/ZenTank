package de.aquazen.backend.dosing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DosingRepository extends JpaRepository<DosingEntity, Long> {
    Optional<DosingEntity> findById(Long id);
}
