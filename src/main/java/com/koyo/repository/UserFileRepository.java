package com.koyo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.koyo.model.UserFiles;

@Repository

public interface UserFileRepository extends CrudRepository<UserFiles, Long> {

}
