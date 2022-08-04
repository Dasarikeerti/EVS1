package com.project.electronicvotingsystem.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
public class ElectrolOfficerEntity {
	
	@Id
	@SequenceGenerator(name="EO_SEQ_GEN", sequenceName="EO_SEQ_GEN", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EO_SEQ_GEN")
	private int id;
	
	@NotNull(message="name is mandatory")
	private String name;

	@Email(message="enter correct email  example@gmail.com")
	private String email;
	
	@NotNull(message="password is mandatory")
	private String password;
	
	public ElectrolOfficerEntity() {
		super();
	}

	public ElectrolOfficerEntity(int id, @NotNull(message = "name is mandatory") String name,
			@Email(message = "enter correct email  example@gmail.com") String email,
			@NotNull(message = "password is mandatory") String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}
