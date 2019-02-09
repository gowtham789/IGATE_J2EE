package com.igate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igate.beans.Domain;
import com.igate.beans.Login;
import com.igate.beans.Trainee;
import com.igate.dao.ITraineeDao;

@Service
public class TraineeService implements ITraineeService {

	@Autowired
	ITraineeDao traineeDao;

	
	@Override
	public int addTrainee(Trainee t) {
		return traineeDao.addTrainee(t);
	
	}

	@Override
	public boolean isValidTrainee(int tid) {
		
		return traineeDao.isValidTrainee(tid);
	}

	@Override
	public Trainee viewTraineeById(int pid) {
		
		return traineeDao.viewTraineeById(pid);
	}

	@Override
	public List<Trainee> viewAllTrainees() {
		
		return traineeDao.viewAllTrainees();
	}

	@Override
	public int deleteTrainee(int pid) {
		
		return traineeDao.deleteTrainee(pid);
	}

	@Override
	public boolean isValidAdmin(Login login) {
	
		return traineeDao.isValidAdmin(login);
	}

	@Override
	public List<Domain> getDomain() {
		return traineeDao.getDomain();
	}

	@Override
	public int updateTrainee(Trainee pid) {
		return traineeDao.updateTrainee(pid);
	}

	

}
