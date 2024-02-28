package de.aquazen.backend.settings.service;

import de.aquazen.backend.settings.domain.Settings;
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

    }

    public Optional<Settings> findSettingById(Long id) {

    }

    public Settings createSetting(Settings settings) {

    }

    public Settings updateSetting(Long id, Settings settings) {

    }

    public void deleteSetting(Long id) {

    }
}
