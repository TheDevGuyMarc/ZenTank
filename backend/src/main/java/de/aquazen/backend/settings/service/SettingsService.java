package de.aquazen.backend.settings.service;

import de.aquazen.backend.settings.domain.Settings;
import de.aquazen.backend.settings.exception.SettingsNotFoundException;
import de.aquazen.backend.settings.repository.SettingsEntity;
import de.aquazen.backend.settings.repository.SettingsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SettingsService {
    private final SettingsRepository settingsRepository;

    public SettingsService(SettingsRepository settingsRepository) {
        this.settingsRepository = settingsRepository;
    }

    public List<Settings> findAllSettings() {
        return this.settingsRepository.findAll()
                .stream()
                .map(Settings::new)
                .toList();
    }

    public Optional<Settings> findSettingById(Long id) {
        return this.settingsRepository.findById(id)
                .map(Settings::new);
    }

    public Settings createSetting(Settings settings) {
        return new Settings(this.settingsRepository.saveAndFlush(new SettingsEntity(settings)));
    }

    public Settings updateSetting(Long id, Settings settings) {
        Optional<Settings> existingElement = this.settingsRepository.findById(id)
                .map(Settings::new);

        if (existingElement.isPresent()) {
            Settings updatedElement = existingElement.get();

            updatedElement.setId(settings.getId());
            updatedElement.setName(settings.getName());
            updatedElement.setAddress(settings.getAddress());
            updatedElement.setDisplay(settings.isDisplay());
            updatedElement.setHttps(settings.isHttps());
            updatedElement.setNetworkInterface(settings.getNetworkInterface());
            updatedElement.setNotifications(settings.isNotifications());
            updatedElement.setPprof(settings.isPprof());
            updatedElement.setPrometheus(settings.isPrometheus());
            updatedElement.setRpi_pwm_freq(settings.getRpi_pwm_freq());

            return new Settings(this.settingsRepository.saveAndFlush(new SettingsEntity(updatedElement)));
        }
        else {
            throw new SettingsNotFoundException("Couldn't find the settings entry you requested with id: " + id);
        }
    }

    public void deleteSetting(Long id) {
        this.settingsRepository.deleteById(id);
    }
}
