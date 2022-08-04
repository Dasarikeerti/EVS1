package com.project.electronicvotingsystem.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.electronicvotingsystem.Entity.AdminEntity;
import com.project.electronicvotingsystem.Exception.AdminNotFoundException;


@Service
public interface AdminService {

	public List<AdminEntity> getAllAdmin();
	
	public Optional<AdminEntity> getAdmin(int id) throws AdminNotFoundException;
	
	public AdminEntity addAdmin(AdminEntity adminEntity);
	
	public Optional<AdminEntity> deleteAdmin(int id) throws AdminNotFoundException;
	
	public AdminEntity updateAdmin(int id, AdminEntity adminEntity) throws AdminNotFoundException;

	public List<AdminEntity> getAdminByEmail(String email)throws AdminNotFoundException;
	
}
