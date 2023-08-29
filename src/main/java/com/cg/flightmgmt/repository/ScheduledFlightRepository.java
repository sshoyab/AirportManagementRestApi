package com.cg.flightmgmt.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.flightmgmt.dto.ScheduledFlight;

public interface ScheduledFlightRepository extends JpaRepository<ScheduledFlight, BigInteger>{

}
