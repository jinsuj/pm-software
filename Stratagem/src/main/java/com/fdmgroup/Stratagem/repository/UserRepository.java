package com.fdmgroup.Stratagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.Stratagem.model.User;

public interface UserRepository extends JpaRepository<User, String> {

}
