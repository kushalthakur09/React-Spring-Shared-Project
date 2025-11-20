package com.example.backend.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.auth.entity.RoleEntity;
import com.example.backend.auth.entity.UserEntity;
@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long>{

	RoleEntity findByName(String role);

}