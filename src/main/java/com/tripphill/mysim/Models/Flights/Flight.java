package com.tripphill.mysim.Models.Flights;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
@ToString
public class Flight {
    @Id @GeneratedValue private long id;
    private long aircraft_id;
    private String dep_code;
    private String arr_code;
    private FlightStatus status;
    @Convert(converter = FlightPositionJSONConverter.class)
    private FlightPosition current_position;
    @Convert(converter = FlightPositionListJSONConverter.class)
    private List<FlightPosition> previous_position;
    private String pilot;

    public void setDep_code(String dep_code) {
        this.dep_code = dep_code.toUpperCase();
    }

    public void setArr_code(String arr_code) {
        this.arr_code = arr_code.toUpperCase();
    }
}

