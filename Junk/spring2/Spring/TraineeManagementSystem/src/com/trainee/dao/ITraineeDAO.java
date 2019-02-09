package com.trainee.dao;

import java.util.List;

import com.trainee.bean.Trainee;

public interface ITraineeDAO 
{
	public int addTrainee(Trainee trainee);
	public int deleteTrainee(int traineeId);
	public int updateTrainee(Trainee t);
	public List<Trainee> getAllTrainees();
	public Trainee getTraineeById(int traineeId);
}
