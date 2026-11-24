package com.vcube.CivicPulse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcube.CivicPulse.model.Grievance;

@Repository
public interface GrievanceRepo extends JpaRepository<Grievance, Long>{
	
	public abstract List<Grievance> findByCategory(String category);

}
