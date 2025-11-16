package com.example.backend.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.auth.entity.UserEntity;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{

}
