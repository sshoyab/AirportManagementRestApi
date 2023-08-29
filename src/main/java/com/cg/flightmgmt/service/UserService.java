package com.cg.flightmgmt.service;

import java.math.BigInteger;
import java.util.List;

import com.cg.flightmgmt.dto.User;
import com.cg.flightmgmt.exception.UserNotFoundException;

public interface UserService {
	public User addUser(User user);
	public User viewUser(BigInteger userId) throws UserNotFoundException;
	public List<User> viewUser();
	public void validateUser(User user);
	public User updateUser(User user);
	public void deleteUser(BigInteger userId);
}
