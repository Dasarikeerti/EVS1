package com.project.electronicvotingsystem.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
public class AdminEntity {
	
	@Id
	@SequenceGenerator(name="admin_SEQ_GEN", sequenceName="admin_SEQ_GEN", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="admin_SEQ_GEN")
	private int id;
	
	@Email(message="enter correct email  example@gmail.com")
	private String email;
	
	@NotNull(message="password is mandatory")
	private String password;

	public AdminEntity(int id ,String email, @NotNull(message = "password is mandatory") String password) {
		super();
		this.id=id;
		this.email = email;
		this.password = password;
	}

	public AdminEntity() {
		super();
	}

	@Override
	public String toString() {
		return "AdminEntity [email=" + email + ", password=" + password + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
