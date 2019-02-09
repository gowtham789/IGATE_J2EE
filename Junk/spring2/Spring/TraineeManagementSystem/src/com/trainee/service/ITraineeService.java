package com.trainee.service;


import java.util.List;
import com.trainee.bean.Trainee;

public interface ITraineeService 
{
	public int addTrainee(Trainee trainee);
	public int deleteTrainee(int traineeId);
	public int updateTrainee(Trainee t);
	public List<Trainee> getAllTrainees();
	public Trainee getTraineeById(int traineeId);
}
