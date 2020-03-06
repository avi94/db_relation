package com.databaserelationship.dbrelationonetomany.controller;

import com.databaserelationship.dbrelationonetomany.resources.entity.InternDetails;
import com.databaserelationship.dbrelationonetomany.resources.entity.Interns;
import com.databaserelationship.dbrelationonetomany.resources.request.InternDetailsRequest;
import com.databaserelationship.dbrelationonetomany.service.InternDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/interns/details")
public class InternDetailsController {

    @Autowired
    InternDetailsService internDetailsService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InternDetails> getAllInternDetails() {
        return internDetailsService.getAllInternDetails();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public InternDetails getInternDetails(@PathVariable("id") Long id) {
        return internDetailsService.getInternDetails(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Interns createInternDetails(@RequestBody @Valid InternDetailsRequest request) {
        return internDetailsService.createInternDetails(request);
    }
}
