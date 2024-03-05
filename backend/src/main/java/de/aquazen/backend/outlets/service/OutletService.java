package de.aquazen.backend.outlets.service;

import de.aquazen.backend.outlets.domain.Outlet;
import de.aquazen.backend.outlets.repository.OutletRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OutletService {
    private final OutletRepository outletRepository;

    public OutletService(OutletRepository outletRepository) {
        this.outletRepository = outletRepository;
    }

    public List<Outlet> findAllOutlets() {

    }

    public Optional<Outlet> findOutletById(Long id) {

    }

    public Outlet createOutlet(Outlet outlet) {

    }

    public Outlet updateOutlet(Long id, Outlet outlet) {

    }

    public void deleteOutlet(Long id) {

    }
}
