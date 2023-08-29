package com.cg.flightmgmt.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flightmgmt.dao.ScheduledFlightDao;
import com.cg.flightmgmt.dto.ScheduledFlight;

@RestController
@RequestMapping("/scheduledFlightController")
public class ScheduledFlightController {
	Logger logger=org.slf4j.LoggerFactory.getLogger(ScheduledFlightController.class);
	
	@Autowired
	private ScheduledFlightDao dao;
	
	//localhost:5010/scheduledFlightController/addScheduleFlight?scheduleId=&flightId=
	@PostMapping(path="/addScheduleFlight")
	public void createBooking(@Valid @RequestBody ScheduledFlight flight, @RequestParam("scheduleId") BigInteger scheduleId,
			@RequestParam("flightId") BigInteger flightId) {
		logger.info("Flight scheduled sucessfully");
		dao.addScheduleFlight(flight, scheduleId, flightId);
	}
	
	//localhost:5010/scheduledFlightController/viewScheduledFlights
	@GetMapping(path="/viewScheduledFlights")
	public List<ScheduledFlight> viewScheduledFlight(){
		return dao.viewScheduledFlights();
		
	}
	
	//localhost:5010/scheduledFlightController/viewScheduledFlights/:source/:destination
	@GetMapping(path="/viewScheduledFlights/{airportSourceCode}/{airportDestCode}")
	public List<ScheduledFlight> viewScheduledFlight(@PathVariable("airportSourceCode") int airportSourceCode, 
			@PathVariable("airportDestCode") int airportDestCode){
		List<ScheduledFlight> list = dao.viewScheduledFlights();
		List<ScheduledFlight> ans = new ArrayList<>();
		for(ScheduledFlight sf: list) {
			if(sf.getSchedule().getSourceAirport().getAirportCode()==airportSourceCode
					&& sf.getSchedule().getDestinationAirport().getAirportCode()==airportDestCode) {
				ans.add(sf);
			}
		}
		return ans;
	}
	
	//localhost:5010/scheduledFlightController/viewScheduledFlights/:flightNum
	@GetMapping(path="/viewScheduledFlight/{flightNumber}")
	public List<ScheduledFlight> viewScheduledFlight(@PathVariable BigInteger flightNumber){
		return dao.viewScheduledFlight(flightNumber);
	}
	
	//localhost:5010/scheduledFlightController/modifyFlightSchedule/:id
	@PostMapping(path="/modifyFlightSchedule/{id}")
	public ScheduledFlight modifyFlightSchedule(@RequestBody ScheduledFlight flight, @PathVariable int id) {
		logger.info("Flight schedule modified");
		return dao.modifyFlightSchedule(flight);
	}
	
	//localhost:5010/scheduledFlightController/deleteScheduledFlight/:id
	@DeleteMapping(path="/deleteScheduledFlight/{scheduleFlightId}")
	public void deleteScheduledFlight(@PathVariable BigInteger scheduleFlightId) {
		logger.info("Flight schedule removed");
		dao.deleteFlightSchedule(scheduleFlightId);
	}
}
