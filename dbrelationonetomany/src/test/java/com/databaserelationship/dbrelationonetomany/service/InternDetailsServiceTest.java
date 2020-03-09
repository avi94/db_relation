package com.databaserelationship.dbrelationonetomany.service;

import com.databaserelationship.dbrelationonetomany.repository.InternDetailsRepository;
import com.databaserelationship.dbrelationonetomany.repository.InternRepository;
import com.databaserelationship.dbrelationonetomany.resources.embed.Address;
import com.databaserelationship.dbrelationonetomany.resources.entity.InternDetails;
import com.databaserelationship.dbrelationonetomany.resources.entity.Interns;
import com.databaserelationship.dbrelationonetomany.resources.enums.Gender;
import com.databaserelationship.dbrelationonetomany.resources.request.InternDetailsRequest;
import com.databaserelationship.dbrelationonetomany.util.exception.InvalidRequestException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class InternDetailsServiceTest {

    @Test
    void createInternDetailsForExceptionChecking() {

        InternRepository internRepository = Mockito.mock(InternRepository.class);
        InternDetailsRepository internDetailsRepository = Mockito.mock(InternDetailsRepository.class);

        InternDetailsService detailsService = new InternDetailsService(internDetailsRepository, internRepository);

        InternDetailsRequest detailsRequest = new InternDetailsRequest(1L, "", 147258);
        Mockito.when(internRepository.findById(detailsRequest.getId())).thenReturn(Optional.empty());

        InvalidRequestException requestException = assertThrows(
                InvalidRequestException.class,
                () -> detailsService.createInternDetails(detailsRequest)
        );

        assertEquals("Intern not found with id 1", requestException.getMessage());

    }

    @Test
    void createInternDetailsToCheckValues() {

        InternRepository internRepository = Mockito.mock(InternRepository.class);
        InternDetailsRepository internDetailsRepository = Mockito.mock(InternDetailsRepository.class);

        InternDetailsService detailsService = new InternDetailsService(internDetailsRepository, internRepository);
        InternDetailsRequest detailsRequest = new InternDetailsRequest(2L, "Kolkata", 147258);

        InternDetails internDetails = new InternDetails(new Address("Kolkata", 147258));
        internDetails.setId(2L);

        Interns intern = new Interns("abc", "xyz", Gender.MALE, LocalDateTime.now());
        intern.setId(2L);
        System.out.println("From Test: " + intern.getId());

        internDetails.setIntern(intern);
        intern.setInternDetails(internDetails);


        System.out.println("From Test: " + intern);
        Mockito.when(internRepository.findById(detailsRequest.getId()))
                .thenReturn(Optional.of(intern));

        System.out.println("From Test: " + intern.getInternDetails());
        System.out.println("From Test lol: " + detailsService.createInternDetails(detailsRequest));
        assertEquals(intern, detailsService.createInternDetails(detailsRequest));

    }

    @Test
    void getInternDetails() {
    }

    @Test
    void getAllInternDetails() {
    }
}