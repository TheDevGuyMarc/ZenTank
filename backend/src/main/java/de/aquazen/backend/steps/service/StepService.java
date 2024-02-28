package de.aquazen.backend.steps.service;

import de.aquazen.backend.steps.domain.Step;
import de.aquazen.backend.steps.repository.StepRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StepService {
    private final StepRepository stepRepository;

    public StepService(StepRepository stepRepository) {
        this.stepRepository = stepRepository;
    }

    public List<Step> findAllSteps() {

    }

    public Optional<Step> findStepById(Long id) {

    }

    public Step createStep(Step step) {

    }

    public Step updateStep(Long id, Step step) {

    }

    public void deleteStep(Long id) {

    }
}
