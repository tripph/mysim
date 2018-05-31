package com.tripphill.mysim.Models.Airports;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "airports")
@NoArgsConstructor
@ToString
public class Airport {
    @Id private String ident;
    private String iso_region;
    private String name;
    private String municipality;
    private Integer elevation_ft;
    private String continent;
    private String type;
    private double lat;
    private double lng;

}
