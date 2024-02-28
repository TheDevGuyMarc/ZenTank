package de.aquazen.backend.macros.service;

import de.aquazen.backend.macros.domain.Macro;
import de.aquazen.backend.macros.repository.MacroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MacroService {
    private final MacroRepository macroRepository;

    public MacroService(MacroRepository macroRepository) {
        this.macroRepository = macroRepository;
    }

    public List<Macro> findAllMacros() {

    }

    public Optional<Macro> findMacroById(Long id) {

    }

    public Macro createMacro(Macro macro) {

    }

    public Macro updateMacro(Long id, Macro macro) {

    }

    public void deleteMacro(Long id) {

    }
}
