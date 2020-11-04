package com.fdmgroup.Stratagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdmgroup.Stratagem.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
