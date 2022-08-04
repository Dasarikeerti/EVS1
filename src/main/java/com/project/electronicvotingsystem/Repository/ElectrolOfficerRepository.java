package com.project.electronicvotingsystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.electronicvotingsystem.Entity.AdminEntity;
import com.project.electronicvotingsystem.Entity.ElectrolOfficerEntity;

@Repository
public interface ElectrolOfficerRepository extends JpaRepository<ElectrolOfficerEntity,Integer> {
	
	List<ElectrolOfficerEntity> findByEmail(String email);
}
