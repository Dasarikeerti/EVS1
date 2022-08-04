package com.project.electronicvotingsystem.DTO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class AdminDTO {
	
	@Id
	private String email;
	
	@NotNull(message="contact is mandatory")
	private String contact;

	public AdminDTO(String email, @NotNull(message = "contact is mandatory") String contact) {
		super();
		this.email = email;
		this.contact = contact;
	}

	public AdminDTO() {
		super();
	}

	@Override
	public String toString() {
		return "AdminEntity [email=" + email + ", contact=" + contact + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	

}
