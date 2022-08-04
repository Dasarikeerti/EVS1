package com.project.electronicvotingsystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.electronicvotingsystem.Entity.AdminEntity;
import com.project.electronicvotingsystem.Entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
	List<UserEntity> findByEmail(String email);
}
