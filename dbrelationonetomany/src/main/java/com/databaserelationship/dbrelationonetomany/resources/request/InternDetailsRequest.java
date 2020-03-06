package com.databaserelationship.dbrelationonetomany.resources.request;

import com.databaserelationship.dbrelationonetomany.resources.embed.Address;
import com.databaserelationship.dbrelationonetomany.resources.entity.Interns;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter @AllArgsConstructor
public class InternDetailsRequest {

    @NotNull(message = "Id cannot be null")
    @JsonProperty("intern_id")
    private Long id;

    @NotEmpty(message = "Address required")
    @JsonProperty("address")
    private String address;

    @NotNull(message = "Zip code is required")
    @JsonProperty("zip_code")
    private Integer zipCode;
}