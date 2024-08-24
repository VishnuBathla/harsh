package com.Practice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Practice.model.UserDtls;

public interface UserRepository extends JpaRepository<UserDtls , Integer> {

	List<UserDtls> findByEmail(String email);

}