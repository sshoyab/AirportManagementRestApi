package com.cg.flightmgmt.service;

import java.math.BigInteger;
import java.util.List;

import com.cg.flightmgmt.dto.ScheduledFlight;

public interface ScheduledFlightService {
	public ScheduledFlight addScheduleFlight(ScheduledFlight flight, BigInteger scheduleId,BigInteger flightNumber);
	public List<ScheduledFlight> viewScheduledFlights();
	public List<ScheduledFlight> viewScheduledFlight(BigInteger flightno);
	public void deleteFlightSchedule(BigInteger flightno);
	public ScheduledFlight modifyFlightSchedule(ScheduledFlight flight);
	public void validateScheduledFlight(ScheduledFlight flight);
}
