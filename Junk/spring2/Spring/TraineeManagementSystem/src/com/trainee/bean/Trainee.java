package com.trainee.bean;

import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
public class Trainee
{
	private int traineeId;
	private String traineeName;
	private String traineeDomain;
	private String traineeLocation;
	
	
	
	public int getTraineeId() 
	{
		return traineeId;
	}
	
	
	public void setTraineeId(int traineeId) 
	{
		this.traineeId = traineeId;
	}
	
	@NotEmpty(message="Please Enter Trainee Name")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Trainee Name must contain only alphabets")
	public String getTraineeName() 
	{
		return traineeName;
	}
	
	public void setTraineeName(String traineeName) 
	{
		this.traineeName = traineeName;
	}
	
	@NotEmpty(message="Please Select Trainee Domain")
	public String getTraineeDomain() 
	{
		return traineeDomain;
	}
	
	public void setTraineeDomain(String traineeDomain)
	{
		this.traineeDomain = traineeDomain;
	}
	
	@NotEmpty(message="Please Select Trainee Location")
	public String getTraineeLocation() 
	{
		return traineeLocation;
	}
	
	public void setTraineeLocation(String traineeLocation) 
	{
		this.traineeLocation = traineeLocation;
	}


	@Override
	public String toString() {
		return "Trainee [traineeId=" + traineeId + ", traineeName="
				+ traineeName + ", traineeDomain=" + traineeDomain
				+ ", traineeLocation=" + traineeLocation + "]";
	}
	
	
	
	
}
