package com.project.electronicvotingsystem.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.electronicvotingsystem.Entity.ElectrolOfficerEntity;
import com.project.electronicvotingsystem.Exception.ElectrolOfficerExistsException;
import com.project.electronicvotingsystem.Exception.ElectrolOfficerNotFound;
import com.project.electronicvotingsystem.Repository.ElectrolOfficerRepository;
import com.project.electronicvotingsystem.Service.ElectrolOfficerService;


@Service
public class ElectrolOfficerServiceImpl implements ElectrolOfficerService {

	@Autowired
	private ElectrolOfficerRepository electrolOfficerRepo;
	
	@Override
	public List<ElectrolOfficerEntity> getAllElectrolOfficer() {
		return electrolOfficerRepo.findAll();
	}

	@Override
	public Optional<ElectrolOfficerEntity> getElectrolOfficer(int id) throws ElectrolOfficerNotFound {
			Optional<ElectrolOfficerEntity> electrolOfficerData = electrolOfficerRepo.findById(id);
			if(!electrolOfficerData.isEmpty()) {
				return electrolOfficerRepo.findById(id);
			}
			else {
				throw new ElectrolOfficerNotFound("ElectrolOfficer Data not found");
			}
	}

	@Override
	public ElectrolOfficerEntity addElectrolOfficer(ElectrolOfficerEntity electrolOfficerEntity) {
		// TODO Auto-generated method stub
		Optional<ElectrolOfficerEntity> electrolOfficerData = electrolOfficerRepo.findById(electrolOfficerEntity.getId()); 
		List<ElectrolOfficerEntity> electrolOfficerByMail = electrolOfficerRepo.findByEmail(electrolOfficerEntity.getEmail());
		if(electrolOfficerData.isEmpty() && electrolOfficerByMail.size()==0) {
			return electrolOfficerRepo.save(electrolOfficerEntity);
		}
		else {
			throw new ElectrolOfficerExistsException("ElectrolOfficer already exists with id "+electrolOfficerEntity.getEmail());
		}
	}

	@Override
	public Optional<ElectrolOfficerEntity> deleteElectrolOfficer(int id) throws ElectrolOfficerNotFound {

		try {
			Optional<ElectrolOfficerEntity> electrolOfficerData = electrolOfficerRepo.findById(id);
			if(!electrolOfficerData.isEmpty()) {
				electrolOfficerRepo.deleteById(id);
				return electrolOfficerData;
			}
			else {
				throw new ElectrolOfficerNotFound("ElectrolOfficer Data not found");
			}
		}
		catch(Exception e){
			throw new ElectrolOfficerNotFound("ElectrolOfficer Data not found");
		}
	}

	@Override
	public ElectrolOfficerEntity updateElectrolOfficer(int id, ElectrolOfficerEntity electrolOfficerEntity) throws ElectrolOfficerNotFound {
		try {
			Optional<ElectrolOfficerEntity> electrolOfficerData = electrolOfficerRepo.findById(id);
			if(!electrolOfficerData.isEmpty()) {
				electrolOfficerEntity.setId(id);
				return electrolOfficerRepo.save(electrolOfficerEntity);
			}
			else {
				throw new ElectrolOfficerNotFound("ElectrolOfficer Data not found");
			}
		}
		catch(Exception e){
			throw new ElectrolOfficerNotFound("ElectrolOfficer Data not found");
		}	
	}

	@Override
	public List<ElectrolOfficerEntity> getElectrolOfficerByEmail(String email) throws ElectrolOfficerNotFound{
		List<ElectrolOfficerEntity> electrolOfficerData = electrolOfficerRepo.findByEmail(email);
		if(electrolOfficerData.size()==0) {
			throw new ElectrolOfficerNotFound("ElectrolOfficer not found");
		}
		return electrolOfficerData;
	}
	

}

