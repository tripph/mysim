package com.tripphill.mysim.Models.Flights;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import javax.validation.constraints.NotNull;

public class FlightPositionJSONConverter implements AttributeConverter<FlightPosition, String> {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    @NotNull
    public String convertToDatabaseColumn(@NotNull FlightPosition myCustomObject) {
        try {
            return objectMapper.writeValueAsString(myCustomObject);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    @NotNull
    public FlightPosition convertToEntityAttribute(@NotNull String databaseDataAsJSONString) {
        try {
            return objectMapper.readValue(databaseDataAsJSONString, FlightPosition.class);
        } catch (Exception ex) {
            return null;
        }
    }
}