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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.electronicvotingsystem.Entity.ElectrolOfficerEntity;
import com.project.electronicvotingsystem.Entity.VoterRequestEntity;
import com.project.electronicvotingsystem.Exception.ElectrolOfficerNotFound;
import com.project.electronicvotingsystem.Exception.VoterRequestNotFoundException;
import com.project.electronicvotingsystem.Service.ElectrolOfficerService;
import com.project.electronicvotingsystem.Service.VoterRequestService;

@RestController
@RequestMapping("/EO")
public class ElectrolOfficerController {
	
	@Autowired
	private VoterRequestService voterRequestServices;
	
	@GetMapping("/view-voterRequest")
	public List<VoterRequestEntity> getAllLogin() {
		return voterRequestServices.getAllVoterRequest();
	}
	
	@GetMapping("view-voterRequest-by-id/{id}")
	public Optional<VoterRequestEntity> getLoginById(@PathVariable int id) throws VoterRequestNotFoundException {
		return voterRequestServices.getVoterRequest(id);
	}
	
	@PutMapping("approve-voterRequest/{id}")
	public VoterRequestEntity updateLogin(@PathVariable int id,@RequestParam String status) throws VoterRequestNotFoundException {
		
		Optional<VoterRequestEntity> voterReq = voterRequestServices.getVoterRequest(id);
		voterReq.get().setApplicationStatus(status);
		
		return voterRequestServices.updateVoterRequest(id, voterReq.get());
	}
	
	@Autowired
	private ElectrolOfficerService electrolOfficerServices;
	
	@GetMapping("/electrolOfficer")
	public List<ElectrolOfficerEntity> getAllElectrolOfficer() {
		return electrolOfficerServices.getAllElectrolOfficer();
	}
	
	@GetMapping("electrolOfficer/{id}")
	public Optional<ElectrolOfficerEntity> getElectrolOfficerById(@PathVariable int id) throws ElectrolOfficerNotFound {
		return electrolOfficerServices.getElectrolOfficer(id);
	}
	
	@GetMapping("electrolOfficer-by-email/{email}")
	public List<ElectrolOfficerEntity> getElectrolOfficerByEmail(@PathVariable String email) throws ElectrolOfficerNotFound {
		return electrolOfficerServices.getElectrolOfficerByEmail(email);
	}
	
	@PostMapping("electrolOfficer")
	public ElectrolOfficerEntity addElectrolOfficer(@Valid @RequestBody ElectrolOfficerEntity electrolOfficerEntity) {
		return electrolOfficerServices.addElectrolOfficer(electrolOfficerEntity);
	}
	
	@PutMapping("electrolOfficer/{id}")
	public ElectrolOfficerEntity updateElectrolOfficer(@PathVariable int id,@Valid @RequestBody ElectrolOfficerEntity electrolOfficerEntity) throws ElectrolOfficerNotFound {
		return electrolOfficerServices.updateElectrolOfficer(id, electrolOfficerEntity);
	}
	
	@DeleteMapping("electrolOfficer/{id}")
	public Optional<ElectrolOfficerEntity> deleteElectrolOfficer(@PathVariable int id) throws ElectrolOfficerNotFound {
		return electrolOfficerServices.deleteElectrolOfficer(id);
	}
}
