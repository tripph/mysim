package com.tripphill.mysim.Models.Flights;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

public class FlightPositionListJSONConverter implements AttributeConverter<List<FlightPosition>, String> {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    @NotNull
    public String convertToDatabaseColumn(@NotNull List<FlightPosition> myCustomObject) {
        try {
            return objectMapper.writeValueAsString(myCustomObject);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    @NotNull
    public List<FlightPosition> convertToEntityAttribute(@NotNull String databaseDataAsJSONString) {
        try {
            return Arrays.asList(objectMapper.readValue(databaseDataAsJSONString, FlightPosition[].class));
        } catch (Exception ex) {
            return null;
        }
    }
}