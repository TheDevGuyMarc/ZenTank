package de.aquazen.backend.ato.service;

import de.aquazen.backend.ato.domain.Ato;
import de.aquazen.backend.ato.exception.AtoNotFoundException;
import de.aquazen.backend.ato.repository.AtoEntity;
import de.aquazen.backend.ato.repository.AtoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtoService {
    private final AtoRepository atoRepository;

    public AtoService(AtoRepository atoRepository) {
        this.atoRepository = atoRepository;
    }

    public List<Ato> findAllAtos() {
        return this.atoRepository.findAll()
            .stream()
            .map(Ato::new)
            .toList();
    }

    public Optional<Ato> findAtoById(Long id) {
        return this.atoRepository.findById(id)
            .map(Ato::new);
    }

    public Ato createAto(Ato ato) {
        return new Ato(this.atoRepository.saveAndFlush(new AtoEntity(ato)));
    }

    public Ato updateAto(Long id, Ato ato) {
        Optional<Ato> existingElement = this.atoRepository.findById(id)
            .map(Ato::new);

        if (existingElement.isPresent()) {
            Ato updatedElement = existingElement.get();

            updatedElement.setId(ato.getId());
            updatedElement.setName(ato.getName());
            updatedElement.setAlerts(ato.isAlerts());
            updatedElement.setCheckFrequency(ato.getCheckFrequency());
            updatedElement.setStatus(ato.getStatus());
            updatedElement.setInlet(ato.getInlet());
            updatedElement.setEquipment(ato.getEquipment());

            return new Ato(this.atoRepository.saveAndFlush(new AtoEntity(updatedElement)));
        }
        else {
            throw new AtoNotFoundException("Couldn't find the ato entry you requested with id: " + id);
        }
    }

    public void deleteAto(Long id) {
        this.atoRepository.deleteById(id);
    }

    public void history(Long id) {
        /* TODO: Implement this method */

        /*
         * Concept:
         * This should return the usage history of the ato
         */
    }
}
