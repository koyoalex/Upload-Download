package com.koyo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.koyo.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
