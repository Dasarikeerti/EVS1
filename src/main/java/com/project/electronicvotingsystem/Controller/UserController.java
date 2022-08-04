package com.project.electronicvotingsystem.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.electronicvotingsystem.Entity.UserEntity;
import com.project.electronicvotingsystem.Exception.UserNotFoundException;
import com.project.electronicvotingsystem.Service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userServices;
	
	@GetMapping("/user")
	public List<UserEntity> getAllUser() {
		return userServices.getAllUser();
	}
	
	@GetMapping("user/{id}")
	public Optional<UserEntity> getUserById(@PathVariable int id) throws UserNotFoundException {
		return userServices.getUser(id);
	}
	
	@PostMapping("user")
	public UserEntity addUser(@Valid @RequestBody UserEntity userEntity) {
		return userServices.addUser(userEntity);
	}
	
	@PutMapping("user/{id}")
	public UserEntity updateUser(@PathVariable int id,@Valid @RequestBody UserEntity userEntity) throws UserNotFoundException {
		return userServices.updateUser(id, userEntity);
	}
	
	@DeleteMapping("user/{id}")
	public Optional<UserEntity> deleteUser(@PathVariable int id) throws UserNotFoundException {
		return userServices.deleteUser(id);
	}
	@GetMapping("user-by-email/{email}")
	public List<UserEntity> getUserByEmail(@PathVariable String email) throws UserNotFoundException {
		return userServices.getUserByEmail(email);
	}
}

