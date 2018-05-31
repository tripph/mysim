package com.tripphill.mysim.Controllers;

import com.tripphill.mysim.Models.Airports.Airport;
import com.tripphill.mysim.Models.Flights.Flight;
import com.tripphill.mysim.Models.Flights.FlightDTO;
import com.tripphill.mysim.Models.Flights.FlightPosition;
import com.tripphill.mysim.Repositories.FlightRepository;
import com.tripphill.mysim.Services.AirportService;
import com.tripphill.mysim.Services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@RestController
public class Flights {
    private final FlightRepository flightRepository;
    private final FlightService flightService;
    private final AirportService airportService;
    @Autowired
    public Flights(FlightRepository flightRepository, FlightService flightService, AirportService airportService) {
        this.flightRepository = flightRepository;
        this.flightService = flightService;
        this.airportService = airportService;
    }

    @GetMapping("/flights")
    public List<FlightDTO> getFlights() {
        return this.flightService.getAllFlightDTOs();
    }

    @PostMapping("/flights/create")
    public Flight createFlight(@RequestBody Flight flight) {
        Optional<Airport> dep = this.airportService.getAirportByIdent(flight.getDep_code());
        if(!dep.isPresent()) {
            return null;
        }
        Airport d = dep.get();
        FlightPosition curpos = new FlightPosition(d.getLat(), d.getLng(), d.getElevation_ft(), Timestamp.from(Instant.now()));
        flight.setCurrent_position(curpos);
        return this.flightRepository.save(flight);
    }
}
