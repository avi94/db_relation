package com.databaserelationship.dbrelationonetomany.resources.embed;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class Address {

    @JsonProperty("address")
    private String address;

    @JsonProperty("zip_code")
    private Integer zipCode;
}
