package com.cg.flightmgmt.service;

import java.util.List;

import com.cg.flightmgmt.dto.Airport;
import com.cg.flightmgmt.exception.AirportNotFoundException;

public interface AirportService {
	public Airport addAirport(Airport airport);
    public List<Airport> viewAirport();
    public Airport viewAirport(int airportCode) throws AirportNotFoundException;
}
