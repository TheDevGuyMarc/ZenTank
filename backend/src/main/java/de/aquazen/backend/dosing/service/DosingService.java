package de.aquazen.backend.dosing.service;

import de.aquazen.backend.dosing.domain.Dosing;
import de.aquazen.backend.dosing.repository.DosingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DosingService {
    private final DosingRepository dosingRepository;

    public DosingService(DosingRepository dosingRepository) {
        this.dosingRepository = dosingRepository;
    }

    public List<Dosing> findAllDosingSystems() {

    }

    public Optional<Dosing> findDosingSystemById(Long id) {

    }

    public Dosing createDosingSystem(Dosing dosing) {

    }

    public Dosing updateDosingSystem(Long id, Dosing dosing) {

    }

    public void deleteDosingSystem(Long id) {

    }
}
