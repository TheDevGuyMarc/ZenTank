package de.aquazen.backend.regiment.service;

import de.aquazen.backend.regiment.domain.Regiment;
import de.aquazen.backend.regiment.exception.RegimentNotFoundException;
import de.aquazen.backend.regiment.repository.RegimentEntity;
import de.aquazen.backend.regiment.repository.RegimentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegimentService {
    private final RegimentRepository regimentRepository;

    public RegimentService(RegimentRepository regimentRepository) {
        this.regimentRepository = regimentRepository;
    }

    public List<Regiment> findAllRegiments() {
        return this.regimentRepository.findAll()
            .stream()
            .map(Regiment::new)
            .toList();
    }

    public Optional<Regiment> findRegimentById(Long id) {
        return this.regimentRepository.findById(id)
            .map(Regiment::new);
    }

    public Regiment createRegiment(Regiment regiment) {
        return new Regiment(this.regimentRepository.saveAndFlush(new RegimentEntity(regiment)));
    }

    public Regiment updateRegiment(Long id, Regiment regiment) {
        Optional<Regiment> existingElement = this.regimentRepository.findById(id)
            .map(Regiment::new);

        if (existingElement.isPresent()) {
            Regiment updatedElement = existingElement.get();

            updatedElement.setId(regiment.getId());
            updatedElement.setDuration(regiment.getDuration());
            updatedElement.setSpeed(regiment.getSpeed());
            updatedElement.setState(regiment.isState());
            updatedElement.setDosing(regiment.getDosing());

            return new Regiment(this.regimentRepository.saveAndFlush(new RegimentEntity(updatedElement)));
        }
        else {
            throw new RegimentNotFoundException("Couldn't find the regiment entry you requested with id: " + id);
        }
    }

    public void deleteRegiment(Long id) {
        this.regimentRepository.deleteById(id);
    }
}
