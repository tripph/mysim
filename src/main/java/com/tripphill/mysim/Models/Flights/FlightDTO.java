package com.tripphill.mysim.Models.Flights;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class FlightDTO {
    private long id;
    private String dep_code;
    private String arr_code;
    private FlightStatus flight_status;


    public FlightDTO(Flight f) {
        this.id = f.getId();
        this.dep_code = f.getDep_code();
        this.arr_code = f.getArr_code();
    }
}
