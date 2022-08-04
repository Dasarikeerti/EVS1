package com.project.electronicvotingsystem.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.electronicvotingsystem.Repository.AdminRepository;
import com.project.electronicvotingsystem.Entity.AdminEntity;
import com.project.electronicvotingsystem.Exception.AdminAlreadyExistsException;
import com.project.electronicvotingsystem.Exception.AdminNotFoundException;
import com.project.electronicvotingsystem.Service.AdminService;


@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepo;
	
	@Override
	public List<AdminEntity> getAllAdmin() {
		return adminRepo.findAll();
	}

	@Override
	public Optional<AdminEntity> getAdmin(int id) throws AdminNotFoundException {
		try {
			Optional<AdminEntity> adminData = adminRepo.findById(id);
			if(!adminData.isEmpty()) {
				return adminRepo.findById(id);
			}
			else {
				throw new AdminNotFoundException("Admin Data not found");
			}
		}
		catch(Exception e){
			throw new AdminNotFoundException("Admin Data not found");
		}	
	}

	@Override
	public AdminEntity addAdmin(AdminEntity adminEntity) {
		// TODO Auto-generated method stub
		
		Optional<AdminEntity> adminData = adminRepo.findById(adminEntity.getId()); 
		List<AdminEntity> adminByMail = adminRepo.findByEmail(adminEntity.getEmail());
		if(adminData.isEmpty() && adminByMail.size()==0) {
			return adminRepo.save(adminEntity);
		}
		else {
			throw new AdminAlreadyExistsException("Admin already exists with id "+adminEntity.getEmail());
		}
	}

	@Override
	public Optional<AdminEntity> deleteAdmin(int id) throws AdminNotFoundException {

		try {
			Optional<AdminEntity> adminData = adminRepo.findById(id);
			if(!adminData.isEmpty()) {
				adminRepo.deleteById(id);
				return adminData;
			}
			else {
				throw new AdminNotFoundException("Admin Data not found");
			}
		}
		catch(Exception e){
			throw new AdminNotFoundException("Admin Data not found");
		}
	}

	@Override
	public AdminEntity updateAdmin(int id, AdminEntity adminEntity) throws AdminNotFoundException {
		try {
			Optional<AdminEntity> adminData = adminRepo.findById(id);
			if(!adminData.isEmpty()) {
				adminEntity.setId(id);
				return adminRepo.save(adminEntity);
			}
			else {
				throw new AdminNotFoundException("Admin Data not found");
			}
		}
		catch(Exception e){
			throw new AdminNotFoundException("Admin Data not found");
		}	
	}

	@Override
	public List<AdminEntity> getAdminByEmail(String email) throws AdminNotFoundException{
		List<AdminEntity> adminData = adminRepo.findByEmail(email);
		if(adminData.size()==0) {
			throw new AdminNotFoundException("Admin not found");
		}
		return adminData;
	}
	

}
