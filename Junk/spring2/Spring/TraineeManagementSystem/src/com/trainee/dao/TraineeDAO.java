package com.trainee.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.trainee.bean.Trainee;
import com.trainee.mappers.TraineeMappers;

@Repository("traineeDao")
public class TraineeDAO extends JdbcDaoSupport implements ITraineeDAO
{

	@Autowired
	private DataSource mydataSource;
	
	@PostConstruct
	private void initialize() 
	{
	setDataSource(mydataSource);
	}
	
	@Override
	public int addTrainee(Trainee trainee) {
		
		int traineeid=trainee.getTraineeId();
    	String traineename=trainee.getTraineeName();
    	String traineedomain=trainee.getTraineeDomain();
    	String traineelocation=trainee.getTraineeLocation();
    	
    	String insertSql="INSERT INTO trainee VALUES(?,?,?,?)";
    	Object[] params=new Object[]{traineeid,traineename,traineedomain,traineelocation};
    	
    	int inserted=getJdbcTemplate().update(insertSql,params);    	
    	System.out.println(inserted);
    	
    	return inserted;
	}

	@Override
	public int deleteTrainee(int traineeId) {
		System.out.println("delete");
		String sql="DELETE FROM trainee WHERE traineeId=?";   
		Object[] params=new Object[]{traineeId};
		return getJdbcTemplate().update(sql, params);
	}

	@Override
	public int updateTrainee(Trainee t) {
		
		String sql="UPDATE trainee SET traineename=?,traineedomain=?,traineelocation=? WHERE traineeid=?";   
		Object[] params=new Object[]{t.getTraineeName(),t.getTraineeDomain(),t.getTraineeLocation(),t.getTraineeId()};
		return getJdbcTemplate().update(sql, params);
	
	}

	@Override
	public List<Trainee> getAllTrainees() {
		System.out.println("in dao");
		String sql="SELECT * FROM trainee";
		 TraineeMappers mapper=new TraineeMappers();
		  List<Trainee> list=getJdbcTemplate().query(sql,mapper);
	     return list;
	}

	@Override
	public Trainee getTraineeById(int traineeId)
	{
		String sql="SELECT * FROM trainee WHERE traineeid=?";
	       Object[] params=new Object[]{traineeId};
	       TraineeMappers mapper=new TraineeMappers();
	       Trainee traineeDetail=(Trainee)getJdbcTemplate().queryForObject(sql,mapper,params);
	     return traineeDetail;
	
	}
	

}
