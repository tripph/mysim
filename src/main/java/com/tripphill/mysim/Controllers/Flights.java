package com.tripphill.mysim.Controllers;

import com.tripphill.mysim.Models.Flights.FlightDTO;
import com.tripphill.mysim.Services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Flights {
    private final FlightService flightService;
    @Autowired

    public Flights(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/flights")
    public List<FlightDTO> getFlights() {
        return this.flightService.getAllFlightDTOs();
    }
}
