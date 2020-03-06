package com.databaserelationship.dbrelationonetomany.service;

import com.databaserelationship.dbrelationonetomany.repository.InternDetailsRepository;
import com.databaserelationship.dbrelationonetomany.repository.InternRepository;
import com.databaserelationship.dbrelationonetomany.resources.embed.Address;
import com.databaserelationship.dbrelationonetomany.resources.entity.InternDetails;
import com.databaserelationship.dbrelationonetomany.resources.entity.Interns;
import com.databaserelationship.dbrelationonetomany.resources.request.InternDetailsRequest;
import com.databaserelationship.dbrelationonetomany.util.exception.InvalidRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InternDetailsService {

    InternDetailsRepository internDetailsRepository;
    InternRepository internRepository;

    public InternDetailsService(InternDetailsRepository internDetailsRepository, InternRepository internRepository) {
        this.internDetailsRepository = internDetailsRepository;
        this.internRepository = internRepository;
    }

    public Interns createInternDetails(InternDetailsRequest request) {

        Address address = new Address(
                request.getAddress(),
                request.getZipCode()
        );
        InternDetails details = new InternDetails(address);

        Optional<Interns> optionalIntern = internRepository.findById(request.getId());

        if (!optionalIntern.isPresent()) {
            throw new InvalidRequestException(String.format("Intern not found with id %s", request.getId()));
        }

        Interns intern = optionalIntern.get();
        intern.setInternDetails(details);

        return internRepository.save(intern);
    }


    public InternDetails getInternDetails(Long id) {
        Optional<InternDetails> optionalInternDetails = internDetailsRepository.findById(id);

        if (!optionalInternDetails.isPresent()) {
            throw new InvalidRequestException(String.format("Intern details with id %s not found", id));
        }

        return optionalInternDetails.get();
    }

    public List<InternDetails> getAllInternDetails() {
        return internDetailsRepository.findAll();
    }
}