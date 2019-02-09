package com.cg.proj.beam;

import java.util.Date;

public class ProjectDto {
	int projectCode;
	String projectName;
	int duration;
	int noOfResources;
	Date stratDate;
	public ProjectDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProjectDto(int projectCode, String projectName, int duration,
			int noOfResources, Date stratDate) {
		super();
		this.projectCode = projectCode;
		this.projectName = projectName;
		this.duration = duration;
		this.noOfResources = noOfResources;
		this.stratDate = stratDate;
	}
	public int getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(int projectCode) {
		this.projectCode = projectCode;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getNoOfResources() {
		return noOfResources;
	}
	public void setNoOfResources(int noOfResources) {
		this.noOfResources = noOfResources;
	}
	public Date getStratDate() {
		return stratDate;
	}
	public void setStratDate(Date stratDate) {
		this.stratDate = stratDate;
	}
	@Override
	public String toString() {
		return "ProjectDto [projectCode=" + projectCode + ", projectName="
				+ projectName + ", duration=" + duration + ", noOfResources="
				+ noOfResources + ", stratDate=" + stratDate + "]";
	}
	
	

}
