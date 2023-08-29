package com.cg.flightmgmt.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.flightmgmt.dto.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, BigInteger> {

}