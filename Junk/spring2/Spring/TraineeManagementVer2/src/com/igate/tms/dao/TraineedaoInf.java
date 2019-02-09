package com.igate.tms.dao;

import java.util.ArrayList;

import com.igate.tms.dto.Trainee;
import com.igate.tms.exception.TraineeException;

public interface TraineedaoInf
{
public int insertTrainee(Trainee tdto) throws TraineeException;
	
	public int updateTrainee(Trainee tdto) throws TraineeException;
	
	public int deleteTrainee(int id) throws TraineeException;
	
	public Trainee viewTrainee(int id) throws TraineeException;
	
	public ArrayList<Trainee> viewAll() throws TraineeException;

}
