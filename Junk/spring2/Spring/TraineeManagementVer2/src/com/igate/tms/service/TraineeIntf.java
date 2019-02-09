package com.igate.tms.service;

import java.util.ArrayList;

import com.igate.tms.dto.Trainee;
import com.igate.tms.exception.TraineeException;

public interface TraineeIntf 
{
	public int insertTrainee(Trainee tdto) throws TraineeException;
	
	public int updateTrainee(Trainee tdto) throws TraineeException;
	
	public int deleteTrainee(int id) throws TraineeException;
	
	public Trainee viewTrainee(int id) throws TraineeException;
	
	public ArrayList<Trainee> viewAll() throws TraineeException;

}
