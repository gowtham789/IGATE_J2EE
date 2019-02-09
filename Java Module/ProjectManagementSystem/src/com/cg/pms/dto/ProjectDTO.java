package com.cg.pms.dto;

import java.sql.Date;

public class ProjectDTO 
{
	private int projectCode;
	private String projectName;
	private int duration;
	private int noOfResources;
	private Date startdate;
	
	
	
	
	public ProjectDTO(int projectCode, String projectName, int duration,
			int noOfResources, Date startdate) {
		super();
		this.projectCode = projectCode;
		this.projectName = projectName;
		this.duration = duration;
		this.noOfResources = noOfResources;
		this.startdate = startdate;
	}
	
	
	
	public ProjectDTO() {
		super();
		// TODO Auto-generated constructor stub
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
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}



	@Override
	public String toString() {
		return "ProjectDTO [projectCode=" + projectCode + ", projectName="
				+ projectName + ", duration=" + duration + ", noOfResources="
				+ noOfResources + ", startdate=" + startdate + "]";
	}
	
	
	
	
	
	
}
