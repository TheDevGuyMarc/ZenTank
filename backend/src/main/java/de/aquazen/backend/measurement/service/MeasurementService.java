package de.aquazen.backend.measurement.service;

import de.aquazen.backend.measurement.domain.Measurement;
import de.aquazen.backend.measurement.repository.MeasurementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurementService {
    private final MeasurementRepository measurementRepository;

    public MeasurementService(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

    public List<Measurement> findAllMeasurements() {

    }

    public Optional<Measurement> findMeasurementById(Long id) {

    }

    public Measurement createMeasurement(Measurement Measurement) {

    }

    public Measurement updateMeasurement(Long id, Measurement Measurement) {

    }

    public void deleteMeasurement(Long id) {

    }
}
