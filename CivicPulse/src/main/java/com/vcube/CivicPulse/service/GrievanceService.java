package com.vcube.CivicPulse.service;

import java.util.List;

import com.vcube.CivicPulse.model.Grievance;

public interface GrievanceService {
	
	public abstract Grievance createGrievence(Grievance grievance);
	
	public abstract List<Grievance> getAllGrievances();
	
	public abstract Grievance getAllGrievaceById(Long id);
	
	public abstract Grievance updateGrivenceById(Grievance grievance,Long id);

	public void   deleteGrievanceById(Long id);
	
	public abstract List<Grievance> getGrievaceByCategory(String category);
	
}
