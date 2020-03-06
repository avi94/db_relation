package com.databaserelationship.dbrelationonetomany.resources.entity;

import com.databaserelationship.dbrelationonetomany.resources.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "interns")
@Getter @Setter @NoArgsConstructor
public class Interns {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @JsonProperty("gender")
    private Gender gender;

    @JsonProperty("time")
    private LocalDateTime dateTime;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @JsonProperty("details")
    @JsonIgnoreProperties("intern")
    private InternDetails internDetails;


    public Interns(String firstName, String lastName, Gender gender, LocalDateTime dateTime) {
        this(firstName, lastName, gender, dateTime, null);
    }

    public Interns(String firstName, String lastName, Gender gender, LocalDateTime dateTime, InternDetails internDetails) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateTime = dateTime;
        this.internDetails = internDetails;
    }
}