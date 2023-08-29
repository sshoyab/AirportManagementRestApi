package com.cg.flightmgmt.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.flightmgmt.dto.User;

public interface UserRepository extends JpaRepository<User, BigInteger>{

}
