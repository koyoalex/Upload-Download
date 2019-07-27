package com.koyo.service;

import java.util.List;

import com.koyo.model.User;

public interface UserService {

	List<User> getAllUsers();

	User save(User user);

}
