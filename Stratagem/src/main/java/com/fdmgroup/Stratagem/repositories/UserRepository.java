package com.fdmgroup.Stratagem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.Stratagem.model.User;

public interface UserRepository extends JpaRepository<User, String> {

}
