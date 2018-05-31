package com.tripphill.mysim.Models.Flights;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@ToString
public class FlightPosition {
    private double lat;
    private double lng;
    private int altitude;
    private Timestamp timestamp;
}
