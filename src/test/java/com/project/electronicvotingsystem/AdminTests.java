package com.project.electronicvotingsystem;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.electronicvotingsystem.Entity.AdminEntity;
import com.project.electronicvotingsystem.Exception.AdminNotFoundException;
import com.project.electronicvotingsystem.Service.AdminService;

@ExtendWith(MockitoExtension.class)
public class AdminTests {

	@Mock
	AdminService adminService;

	@Test
	void addAdminTest(){
		AdminEntity adminEntity = new AdminEntity(1,"mahii@qwe.com","7412589630");
		when(adminService.addAdmin(adminEntity)).thenReturn(adminEntity);
		assertEquals(adminService.addAdmin(adminEntity),adminEntity);
	}
	
	@Test
	void getAdminTest() throws AdminNotFoundException {
		AdminEntity adminEntity = new AdminEntity(1,"mahii@qwe.com","7412589630");
		Optional<AdminEntity> OAdminEntity = Optional.of(adminEntity);
		when(adminService.getAdmin(1)).thenReturn(OAdminEntity);
		assertEquals(adminService.getAdmin(1).get(),adminEntity);
	}
	
	@Test
	void updateAdminTest() throws AdminNotFoundException {
		AdminEntity adminEntity = new AdminEntity(1,"mahii@qwe.com","7412589630");
		when(adminService.updateAdmin(1,adminEntity)).thenReturn(adminEntity);
		assertEquals(adminService.updateAdmin(1,adminEntity),adminEntity);
	}
	
	@Test
	void deleteAdminTest() throws AdminNotFoundException {
		AdminEntity adminEntity = new AdminEntity(1,"mahii@qwe.com","7412589630");
		Optional<AdminEntity> OAdminEntity = Optional.of(adminEntity);
		when(adminService.deleteAdmin(1)).thenReturn(OAdminEntity);
		assertEquals(adminService.deleteAdmin(1).get(),adminEntity);
	}

}
