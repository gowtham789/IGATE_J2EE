package com.igate.tms.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igate.tms.dao.TraineedaoInf;
import com.igate.tms.dto.Trainee;
import com.igate.tms.exception.TraineeException;

@Service("TraineeService")
public class TraineeServimp implements TraineeIntf 
{
	@Autowired
	TraineedaoInf tdao;
	
	@Override
	public int insertTrainee(Trainee tdto) throws TraineeException {
		
		return tdao.insertTrainee(tdto);
	}

	@Override
	public int updateTrainee(Trainee tdto) throws TraineeException {
		
		return tdao.updateTrainee(tdto);
	}

	@Override
	public int deleteTrainee(int id) throws TraineeException {
		
		return tdao.deleteTrainee(id);
	}

	@Override
	public Trainee viewTrainee(int id) throws TraineeException {
		
		return tdao.viewTrainee(id);
	}

	@Override
	public ArrayList<Trainee> viewAll() throws TraineeException {
		
		return tdao.viewAll();
	}

}
