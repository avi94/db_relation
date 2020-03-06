package com.databaserelationship.dbrelationonetomany.resources.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public final class ErrorResponse {

    @JsonProperty("message")
    private String message;

    @JsonProperty("error_type")
    private String errorType;
}
