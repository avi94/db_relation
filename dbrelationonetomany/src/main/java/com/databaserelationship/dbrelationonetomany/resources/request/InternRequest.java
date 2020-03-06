package com.databaserelationship.dbrelationonetomany.resources.request;

import com.databaserelationship.dbrelationonetomany.resources.enums.Gender;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class InternRequest {

    @NotEmpty(message = "First name cannot be empty or null")
    @JsonProperty("first_name")
    private String firstName;

    @NotEmpty(message = "Last name must not be empty or null")
    @JsonProperty("last_name")
    private String lastName;

    @NotNull(message = "Gender cannot be null")
    @JsonProperty("gender")
    private Gender gender;
}
