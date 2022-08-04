package com.project.electronicvotingsystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.electronicvotingsystem.Entity.ElectrolOfficerEntity;
import com.project.electronicvotingsystem.Exception.ElectrolOfficerNotFound;

@Service
public interface ElectrolOfficerService {

	public List<ElectrolOfficerEntity> getAllElectrolOfficer();
	
	public Optional<ElectrolOfficerEntity> getElectrolOfficer(int id) throws ElectrolOfficerNotFound;
	
	public ElectrolOfficerEntity addElectrolOfficer(ElectrolOfficerEntity electrolOfficerEntity);
	
	public Optional<ElectrolOfficerEntity> deleteElectrolOfficer(int id) throws ElectrolOfficerNotFound;
	
	public ElectrolOfficerEntity updateElectrolOfficer(int id, ElectrolOfficerEntity electrolOfficerEntity) throws ElectrolOfficerNotFound;

	public List<ElectrolOfficerEntity> getElectrolOfficerByEmail(String email)throws ElectrolOfficerNotFound;
	
}
