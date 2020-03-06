package com.databaserelationship.dbrelationonetomany.service;

import com.databaserelationship.dbrelationonetomany.repository.InternRepository;
import com.databaserelationship.dbrelationonetomany.resources.entity.Interns;
import com.databaserelationship.dbrelationonetomany.resources.enums.Gender;
import com.databaserelationship.dbrelationonetomany.resources.request.InternRequest;
import com.databaserelationship.dbrelationonetomany.util.exception.InvalidRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class InternService {

    @Autowired
    InternRepository internRepository;

    public Interns createIntern(InternRequest request) {

        Interns intern = new Interns(
                request.getFirstName(),
                request.getLastName(),
                request.getGender(),
                LocalDateTime.now()
        );
        return internRepository.save(intern);
    }

    public Interns updateIntern(Long id, InternRequest request) {

        Optional<Interns> optionalIntern = internRepository.findById(id);

        Interns intern = null;
        if (optionalIntern.isPresent()) {
            intern = optionalIntern.get();
        }

        intern.setFirstName(request.getFirstName());
        intern.setLastName(request.getLastName());
        intern.setGender(request.getGender());

        return internRepository.save(intern);
    }

    public void deleteIntern(Long id) {
        boolean exists = internRepository.existsById(id);

        if (exists) {
            internRepository.deleteById(id);
        }
    }

    public List<Interns> getAllInterns() {
        return internRepository.findAll();
    }

    public Interns getIntern(Long id) {
        Optional<Interns> optionalIntern = internRepository.findById(id);;

        if (!optionalIntern.isPresent()) {
            throw new InvalidRequestException(String.format("Intern with id %s not found", id));
        }

        return optionalIntern.get();
    }

    public List<Interns> findByName(String name) {
        return internRepository.findByName(name);
    }
}
