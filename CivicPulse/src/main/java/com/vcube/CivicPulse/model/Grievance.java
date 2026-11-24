package com.vcube.CivicPulse.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="grievance73")
@Setter
@Getter

public class Grievance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long grievanceId;
	private String citizenName;
	private String category;
	private String description;
	private String severity;
	private String location;
	private LocalDate reportedDate;
	
}
