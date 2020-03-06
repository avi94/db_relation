package com.databaserelationship.dbrelationonetomany.resources.entity;

import com.databaserelationship.dbrelationonetomany.resources.embed.Address;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "intern_details")
@Getter @Setter @NoArgsConstructor @ToString
public class InternDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("address")
    @Embedded
    private Address address;

    @OneToOne(mappedBy = "internDetails")
    @JsonIgnoreProperties("details")
    private Interns intern;

    public InternDetails(Address address) {
        this.address = address;
    }
}