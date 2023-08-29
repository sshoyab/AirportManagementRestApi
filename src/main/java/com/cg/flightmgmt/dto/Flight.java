package com.cg.flightmgmt.dto;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Flight_table")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Flight {
	@Id
	@NotNull(message="Flight Number should not be null")
	@Column(name="flightnumber")
	private BigInteger flightNumber;
	@NotEmpty(message="Carrier Name should not be empty")
	@Column(name="carrierName")
	private String carrierName;
	@NotEmpty(message="Flight Model should not be empty")
	@Column(name="flightModel")
	private String flightModel;
	@NotNull(message="Seat Capacity should not be null")
	@Column(name="seatCapacity")
	private int seatCapacity;
	public Flight() {
		super();
	}
	public Flight(BigInteger flightNumber, String carrierName, String flightModel, int seatCapacity) {
		super();
		this.flightNumber = flightNumber;
		this.carrierName = carrierName;
		this.flightModel = flightModel;
		this.seatCapacity = seatCapacity;
	}
	public BigInteger getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(BigInteger flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getCarrierName() {
		return carrierName;
	}
	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}
	public String getFlightModel() {
		return flightModel;
	}
	public void setFlightModel(String flightModel) {
		this.flightModel = flightModel;
	}
	public int getSeatCapacity() {
		return seatCapacity;
	}
	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}
}
