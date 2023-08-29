package com.cg.flightmgmt.dao;

import com.cg.flightmgmt.dto.Schedule;
import com.cg.flightmgmt.repository.ScheduleRepository;
import com.cg.flightmgmt.service.ScheduleService;

import org.hibernate.annotations.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Proxy(lazy=false)
public class ScheduleDao implements ScheduleService {
	
	@Autowired
	private ScheduleRepository rep;

	@Override
	public Schedule createSchedule(	Schedule schedule) {
		return rep.save(schedule);
	}
}
