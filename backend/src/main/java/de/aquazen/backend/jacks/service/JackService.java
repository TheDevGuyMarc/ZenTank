package de.aquazen.backend.jacks.service;

import de.aquazen.backend.jacks.domain.Jack;
import de.aquazen.backend.jacks.repository.JackRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JackService {
    private final JackRepository jackRepository;

    public JackService(JackRepository jackRepository) {
        this.jackRepository = jackRepository;
    }

    public List<Jack> findAllJacks() {

    }

    public Optional<Jack> findJackById(Long id) {

    }

    public Jack createJack(Jack jack) {

    }

    public Jack updateJack(Long id, Jack jack) {

    }

    public void deleteJack(Long id) {

    }
}
