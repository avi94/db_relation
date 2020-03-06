package com.databaserelationship.dbrelationonetomany.resources.embed;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Address {

    private String address;
    private Integer zipCode;
}
