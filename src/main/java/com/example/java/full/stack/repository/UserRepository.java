package com.example.java.full.stack.repository;

import com.example.java.full.stack.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User  findByUsername(String username);
    // User  findById(Long id);

}
