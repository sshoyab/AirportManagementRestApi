package com.cg.flightmgmt.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flightmgmt.dto.User;
import com.cg.flightmgmt.exception.UserNotFoundException;
import com.cg.flightmgmt.repository.UserRepository;
import com.cg.flightmgmt.service.UserService;

@Service
public class UserDao implements UserService{
	@Autowired
	private UserRepository repo;
	
	@Override
	public User addUser(User user) {
		return repo.save(user);
	}
	
	@Override
	public User viewUser(BigInteger userId) throws UserNotFoundException {
		Optional<User> found = repo.findById(userId);
		if(found.isPresent()) {
			return found.get();
		}else {
			throw new UserNotFoundException("This user does not exist");
		}
	}
	
	@Override
	public List<User> viewUser(){
		return repo.findAll();
	}
	
	@Override
	public void validateUser(User user) {
		
	}
	
	@Override
	public User updateUser(User user) {
		return repo.save(user);
	}
	
	@Override
	public void deleteUser(BigInteger userId) {
		repo.delete(repo.getById(userId));
	}
}
