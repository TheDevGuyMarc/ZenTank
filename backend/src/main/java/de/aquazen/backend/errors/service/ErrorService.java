package de.aquazen.backend.errors.service;

import de.aquazen.backend.errors.domain.Error;
import de.aquazen.backend.errors.exception.ErrorNotFoundException;
import de.aquazen.backend.errors.repository.ErrorEntity;
import de.aquazen.backend.errors.repository.ErrorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ErrorService {
    private final ErrorRepository errorRepository;

    public ErrorService(ErrorRepository errorRepository) {
        this.errorRepository = errorRepository;
    }

    public List<Error> findAllErrors() {
        return this.errorRepository.findAll()
                .stream()
                .map(Error::new)
                .toList();
    }

    public Optional<Error> findErrorById(Long id) {
        return this.errorRepository.findById(id)
                .map(Error::new);
    }

    public Error createError(Error error) {
        return new Error(this.errorRepository.saveAndFlush(new ErrorEntity(error)));
    }

    public Error updateError(Long id, Error error) {
        Optional<Error> existingElement = this.errorRepository.findById(id)
                .map(Error::new);

        if (existingElement.isPresent()) {
            Error updatedElement = existingElement.get();

            updatedElement.setId(error.getId());
            updatedElement.setMessage(error.getMessage());
            updatedElement.setTime(error.getTime());
            updatedElement.setCount(error.getCount());

            return new Error(this.errorRepository.saveAndFlush(new ErrorEntity(updatedElement)));
        }
        else {
            throw new ErrorNotFoundException("Couldn't find the error entry you requested with id: " + id);
        }
    }

    public void deleteError(Long id) {
        this.errorRepository.deleteById(id);
    }
}
