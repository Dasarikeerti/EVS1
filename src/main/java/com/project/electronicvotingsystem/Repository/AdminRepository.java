package com.project.electronicvotingsystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.electronicvotingsystem.Entity.AdminEntity;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity,Integer> {
	
	List<AdminEntity> findByEmail(String email);
}
