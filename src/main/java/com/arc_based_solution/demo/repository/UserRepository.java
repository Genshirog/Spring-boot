package com.arc_based_solution.demo.repository;

import com.arc_based_solution.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
