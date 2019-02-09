package com.igate.dao;

import java.util.List;

import com.igate.beans.Domain;
import com.igate.beans.Login;
import com.igate.beans.Trainee;

public interface ITraineeDao {

	public int addTrainee(Trainee t);
	
	public boolean isValidTrainee(int tid); 
	
	public Trainee viewTraineeById(int pid);
	
	List<Trainee> viewAllTrainees();
	
	public int deleteTrainee(int pid);
	
	public boolean isValidAdmin(Login login);
	
	public List<Domain> getDomain();
	
	public int updateTrainee(Trainee pid);
}
