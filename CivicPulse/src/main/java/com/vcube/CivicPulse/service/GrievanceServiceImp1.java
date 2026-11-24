package com.vcube.CivicPulse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcube.CivicPulse.exception.GrievanceNotFoundException;
import com.vcube.CivicPulse.model.Grievance;
import com.vcube.CivicPulse.repository.GrievanceRepo;

@Service
public class GrievanceServiceImp1 implements GrievanceService{
	
	@Autowired
	GrievanceRepo grievanceRepo;

	@Override
	public Grievance createGrievence(Grievance grievance) {
		System.out.println(grievance.getCitizenName());
 		return grievanceRepo.save(grievance);
	}

	@Override
	public List<Grievance> getAllGrievances() {
  		return grievanceRepo.findAll();
	}

	@Override
	public Grievance getAllGrievaceById(Long id) {
		
 		return grievanceRepo.findById(id).orElseThrow(() ->
        new GrievanceNotFoundException(
                "Expense not found with ID: " + id));
	}

	@Override
	public Grievance updateGrivenceById(Grievance grievance, Long id) {
		Grievance grievanceFromDb = getAllGrievaceById(id);
		
		grievanceFromDb.setCitizenName(grievance.getCitizenName());
		grievanceFromDb.setCategory(grievance.getCategory());
		grievanceFromDb.setDescription(grievance.getDescription());
		grievanceFromDb.setSeverity(grievance.getSeverity());
		grievanceFromDb.setLocation(grievance.getLocation());
		grievanceFromDb.setReportedDate(grievance.getReportedDate());
		
 		return grievanceRepo.save(grievanceFromDb);
	}

	@Override
	public void deleteGrievanceById(Long id) {
		grievanceRepo.deleteById(id);
	}

	@Override
	public List<Grievance> getGrievaceByCategory(String category) {
		return grievanceRepo.findByCategory(category);
	}
	 
}
