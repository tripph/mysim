package com.tripphill.mysim.Controllers;

import com.tripphill.mysim.Models.Airports.Airport;
import com.tripphill.mysim.Models.Flights.FlightDTO;
import com.tripphill.mysim.Services.AirportService;
import com.tripphill.mysim.Services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class Airports {
    private final AirportService airportService;
    private final FlightService flightService;
    @Autowired
    public Airports(AirportService airportService, FlightService flightService) {
        this.airportService = airportService;
        this.flightService = flightService;
    }
    @GetMapping("/airports")
    public List<Airport> airports() {
        return this.airportService.getAllAirports();
    }

    @GetMapping("/airports/active")
    public List<Airport> activeAirports() {
        List<FlightDTO> flights = this.flightService.getAllFlightDTOs();

        Set<String> idents = new HashSet<>();
        flights.forEach(f -> {
            idents.add(f.getArr_code());
            idents.add(f.getDep_code());
        });
        return this.airportService.getAllAirports().stream()
                .filter(a -> idents.contains(a.getIdent()))
                .collect(Collectors.toList());
    }

}
