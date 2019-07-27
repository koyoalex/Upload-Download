package com.koyo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.koyo.model.User;
import com.koyo.repository.UserRepository;

@Service
@Transactional
public class UserServiceImplementation implements UserService{

	@Autowired private UserRepository userRepository ;
	
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
