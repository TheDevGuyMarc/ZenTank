package de.aquazen.backend.capability.service;

import de.aquazen.backend.capability.domain.Capability;
import de.aquazen.backend.capability.exception.CapabilityNotFoundException;
import de.aquazen.backend.capability.repository.CapabilityEntity;
import de.aquazen.backend.capability.repository.CapabilityRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CapabilityService {
    private final CapabilityRepository capabilityRepository;

    public CapabilityService(CapabilityRepository capabilityRepository) {
        this.capabilityRepository = capabilityRepository;
    }

    public List<Capability> findAllCapabilties() {
        return this.capabilityRepository.findAll()
                .stream()
                .map(Capability::new)
                .toList();
    }

    public Optional<Capability> findCapabilityById(Long id) {
        return this.capabilityRepository.findById(id)
                .map(Capability::new);
    }

    public Capability createCapability(Capability Capabilitys) {
        return new Capability(this.capabilityRepository.saveAndFlush(new CapabilityEntity(Capabilitys)));
    }

    public Capability updateCapability(Long id, Capability Capabilitys) {
        Optional<Capability> existingElement = this.capabilityRepository.findById(id)
                .map(Capability::new);

        if (existingElement.isPresent()) {
            Capability updatedElement = existingElement.get();

            updatedElement.setId(Capabilitys.getId());
            updatedElement.setName(Capabilitys.getName());
            updatedElement.setEnabled(Capabilitys.isEnabled());
            updatedElement.setSettings(Capabilitys.getSettings());

            return new Capability(this.capabilityRepository.saveAndFlush(new CapabilityEntity(updatedElement)));
        }
        else {
            throw new CapabilityNotFoundException("Couldn't find the capability entry you requested with id: " + id);
        }
    }

    public void deleteCapability(Long id) {
        this.capabilityRepository.deleteById(id);
    }
}
