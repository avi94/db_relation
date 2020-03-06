package com.databaserelationship.dbrelationonetomany.service;

import com.databaserelationship.dbrelationonetomany.repository.InternDetailsRepository;
import com.databaserelationship.dbrelationonetomany.repository.InternRepository;
import com.databaserelationship.dbrelationonetomany.resources.embed.Address;
import com.databaserelationship.dbrelationonetomany.resources.entity.InternDetails;
import com.databaserelationship.dbrelationonetomany.resources.request.InternDetailsRequest;
import com.databaserelationship.dbrelationonetomany.util.exception.InvalidRequestException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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

        InternDetailsRequest detailsRequest = new InternDetailsRequest(2L, "", 147258);
        InternDetails internDetails = new InternDetails(new Address());
        Mockito.when(detailsService.createInternDetails(detailsRequest)).thenReturn();

//        InvalidRequestException requestException = assertThrows(
//                InvalidRequestException.class,
//                () -> detailsService.createInternDetails(detailsRequest)
//        );

//        assertEquals("Intern not found with id 1", requestException.getMessage());

    }

    @Test
    void getInternDetails() {
    }

    @Test
    void getAllInternDetails() {
    }
}