package com.trainee.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.trainee.bean.Trainee;
import com.trainee.dao.ITraineeDAO;


@Service
public class TraineeService implements ITraineeService
{
	
	@Autowired
	ITraineeDAO traineeDao;
	
	@Override
	public int addTrainee(Trainee trainee) {
		
		return traineeDao.addTrainee(trainee);
	}

	@Override
	public int deleteTrainee(int traineeId) {
		
		return traineeDao.deleteTrainee(traineeId);
	}

	@Override
	public int updateTrainee(Trainee t) {
		
		return traineeDao.updateTrainee(t);
	}

	@Override
	public List<Trainee> getAllTrainees() {
		
		return traineeDao.getAllTrainees();
	}

	@Override
	public Trainee getTraineeById(int traineeId) {
	
		return traineeDao.getTraineeById(traineeId);
	}

}
