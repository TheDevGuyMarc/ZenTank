package de.aquazen.backend.timer.service;

import de.aquazen.backend.timer.domain.Timer;
import de.aquazen.backend.timer.repository.TimerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimerService {
    private final TimerRepository timerRepository;

    public TimerService(TimerRepository timerRepository) {
        this.timerRepository = timerRepository;
    }

    public List<Timer> findAllTimers() {

    }

    public Optional<Timer> findTimerById(Long id) {

    }

    public Timer createTimer(Timer timer) {

    }

    public Timer updateTimer(Long id, Timer timer) {

    }

    public void deleteTimer(Long id) {

    }
}
