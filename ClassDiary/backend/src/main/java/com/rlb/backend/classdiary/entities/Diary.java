package com.rlb.backend.classdiary.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_diary")
public class Diary implements Serializable{ 
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer bimester;
	private String studant;
	private Integer avaluation;
	private Float classroomParticipation;
	private Float deliveryOfTasks;
	private Float bimonthlyWork;
	private Float bimonthlyTest;
	private Integer bimonthlyPeriod;
	private Boolean presenceInTheClasses[];

	public Diary() {
	
	}

	public Diary(Long id, Integer bimester, String studant, Integer avaluation, Float classroomParticipation,
		Float deliveryOfTasks, Float bimonthlyWork, Float bimonthlyTest, Integer bimonthlyPeriod,
		Boolean[] presenceInTheClasses) {
	super();
	this.id = id;
	this.bimester = bimester;
	this.studant = studant;
	this.avaluation = avaluation;
	this.classroomParticipation = classroomParticipation;
	this.deliveryOfTasks = deliveryOfTasks;
	this.bimonthlyWork = bimonthlyWork;
	this.bimonthlyTest = bimonthlyTest;
	this.bimonthlyPeriod = bimonthlyPeriod;
	this.presenceInTheClasses = presenceInTheClasses;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getBimester() {
		return bimester;
	}
	
	public void setBimester(Integer bimester) {
		this.bimester = bimester;
	}
	
	public String getStudant() {
		return studant;
	}
	
	public void setStudant(String studant) {
		this.studant = studant;
	}
	
	public Integer getAvaluation() {
		return avaluation;
	}
	
	public void setAvaluation(Integer avaluation) {
		this.avaluation = avaluation;
	}
	
	public Float getClassroomParticipation() {
		return classroomParticipation;
	}
	
	public void setClassroomParticipation(Float classroomParticipation) {
		this.classroomParticipation = classroomParticipation;
	}
	
	public Float getDeliveryOfTasks() {
		return deliveryOfTasks;
	}
	
	public void setDeliveryOfTasks(Float deliveryOfTasks) {
		this.deliveryOfTasks = deliveryOfTasks;
	}
	
	public Float getBimonthlyWork() {
		return bimonthlyWork;
	}
	
	public void setBimonthlyWork(Float bimonthlyWork) {
		this.bimonthlyWork = bimonthlyWork;
	}
	
	public Float getBimonthlyTest() {
		return bimonthlyTest;
	}
	
	public void setBimonthlyTest(Float bimonthlyTest) {
		this.bimonthlyTest = bimonthlyTest;
	}
	
	public Integer getBimonthlyPeriod() {
		return bimonthlyPeriod;
	}
	
	public void setBimonthlyPeriod(Integer bimonthlyPeriod) {
		this.bimonthlyPeriod = bimonthlyPeriod;
	}
	
	public Boolean[] getPresenceInTheClasses() {
		return presenceInTheClasses;
	}
	
	public void setPresenceInTheClasses(Boolean[] presenceInTheClasses) {
		this.presenceInTheClasses = presenceInTheClasses;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((studant == null) ? 0 : studant.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Diary other = (Diary) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (studant == null) {
			if (other.studant != null)
				return false;
		} else if (!studant.equals(other.studant))
			return false;
		return true;
	}
}
