package com.databaserelationship.dbrelationonetomany.controller;

import com.databaserelationship.dbrelationonetomany.resources.entity.Interns;
import com.databaserelationship.dbrelationonetomany.resources.enums.Gender;
import com.databaserelationship.dbrelationonetomany.resources.request.InternRequest;
import com.databaserelationship.dbrelationonetomany.service.InternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/interns")
public class InternController {

    @Autowired
    InternService internService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Interns> getAllInterns() {
        return internService.getAllInterns();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Interns getIntern(@PathVariable Long id) {
        return internService.getIntern(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Interns createIntern(@RequestBody @Valid InternRequest request) {
        return internService.createIntern(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Interns updateIntern(@PathVariable("id") Long id, @RequestBody InternRequest request) {
        return internService.updateIntern(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteIntern(@PathVariable("id") Long id) {
        internService.deleteIntern(id);
    }

    @GetMapping(value = "/search", params = {"name", "gender"})
    @ResponseStatus(HttpStatus.OK)
    public List<Interns> searchInternsByName(@RequestParam(value = "name") String name) {
        return internService.findByName(name);
    }
}
