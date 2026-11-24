package com.vcube.CivicPulse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.CivicPulse.model.Grievance;
import com.vcube.CivicPulse.service.GrievanceService;

//http://localhost:7777/grievance/hello
@RestController
@RequestMapping("/grievance")
public class GrievanceController {
	
	@Autowired
	GrievanceService grievanceService;
	
	@GetMapping("/hello")
	String hello() {
		return "Civicpulse tracker created successfully";
	}
	
	@PostMapping("/crGri")
	ResponseEntity<Grievance> createGrievance(@RequestBody Grievance grievance) {
	return ResponseEntity.status(HttpStatus.CREATED).body(grievanceService.createGrievence(grievance));
	}
	
	@GetMapping("/getGrievane")
	List<Grievance>getAllGrievances(){
		return grievanceService.getAllGrievances();
	}
	
	@GetMapping("/getGrievaneById/{id}")
	Grievance getAllGrievaceById(@PathVariable Long id){
		return grievanceService.getAllGrievaceById(id);
	}
	
	@PutMapping("/updateGrivenceById/{id}")
	Grievance updateGrivenceById(@RequestBody Grievance grievance,@PathVariable Long id){
		return grievanceService.updateGrivenceById(grievance, id);
	}
	
	@DeleteMapping("/deleteGrievanceById/{id}")
	String deleteGrievanceById(@PathVariable Long id){
		grievanceService.deleteGrievanceById(id);
		return "Deleted Grievances successfully with the id of :"+id;
	}
	
	@GetMapping("/getGrievaceByCategory/{category}")
	List<Grievance> getGrievaceByCategory(@PathVariable String category){
		return grievanceService.getGrievaceByCategory(category);
	}
}
