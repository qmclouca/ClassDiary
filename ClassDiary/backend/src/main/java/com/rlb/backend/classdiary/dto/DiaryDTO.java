package com.rlb.backend.classdiary.dto;

import java.io.Serializable;

import com.rlb.backend.classdiary.entities.Diary;

public class DiaryDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
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
	
	public DiaryDTO () {
		
	}

	public DiaryDTO(Diary entity) {
		super();
		this.id = entity.getId();
		this.bimester = entity.getBimester();
		this.studant = entity.getStudant();
		this.avaluation = entity.getAvaluation();
		this.classroomParticipation = entity.getClassroomParticipation();
		this.deliveryOfTasks = entity.getDeliveryOfTasks();
		this.bimonthlyWork = entity.getBimonthlyWork();
		this.bimonthlyTest = entity.getBimonthlyTest();
		this.bimonthlyPeriod = entity.getBimonthlyPeriod();
		this.presenceInTheClasses = entity.getPresenceInTheClasses();
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
	
	
}
