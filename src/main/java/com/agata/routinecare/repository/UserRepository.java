package com.agata.routinecare.repository;

import com.agata.routinecare.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository <User, Long> {

}
