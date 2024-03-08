package de.aquazen.backend.channel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChannelRepository extends JpaRepository<ChannelEntity, Long> {
    Optional<ChannelEntity> findById(Long id);
}
