package com.igate.tms.dao;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.igate.tms.dto.Trainee;
import com.igate.tms.exception.TraineeException;
import com.igate.tms.mapper.TraineeMapper;

@Repository("tdao")
public class TraineeDao extends JdbcDaoSupport implements TraineedaoInf
{

	@Autowired
	private DataSource MyDataSource;
	
	
	@PostConstruct
	private void initialize() {
	setDataSource(MyDataSource);
	}
	
	
	@Override
	public int insertTrainee(Trainee tdto) throws TraineeException
	{
		String sql="INSERT INTO trainee VALUES(?,?,?,?)";   
		Object[] params=new Object[]{tdto.getId(),tdto.getName(),tdto.getLocation(),tdto.getDomain()};
		return getJdbcTemplate().update(sql, params);
	}

	@Override
	public int updateTrainee(Trainee tdto) throws TraineeException 
	{
		String sql="UPDATE TRAINEE SET name=?,location=?,domain=? where id=?";   
		Object[] params=new Object[]{tdto.getName(),tdto.getLocation(),tdto.getDomain(),tdto.getId()};
		return getJdbcTemplate().update(sql, params);
	}

	@Override
	public int deleteTrainee(int id) throws TraineeException {
		
		System.out.println(id);
		String sql = "DELETE FROM trainee WHERE id=?";
		int del= getJdbcTemplate().update(sql, id);
		return del;
	}

	@Override
	public Trainee viewTrainee(int id) throws TraineeException 
	
	{
		String sql="SELECT * from trainee where id=?";
		Object[] params=new Object[]{id};
	    Trainee td=getJdbcTemplate().queryForObject(sql,new TraineeMapper(),params);
		return td;
	}

	@Override
	public ArrayList<Trainee> viewAll() throws TraineeException 
	{
		ArrayList<Trainee> trainees=(ArrayList<Trainee>) getJdbcTemplate().query("select * from trainee", new TraineeMapper());
		return  trainees;
	}

}
