package com.igate.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.igate.beans.Domain;
import com.igate.beans.Login;
import com.igate.beans.Trainee;
import com.igate.mapper.DomainMapper;
import com.igate.mapper.TraineeMapper;

@Repository
public class TraineeDao extends JdbcDaoSupport implements ITraineeDao{

	@Autowired
	private DataSource myDataSource;
		

	@PostConstruct
	private void initialize() {
	setDataSource(myDataSource);
	}
	
	@Override
	public int addTrainee(Trainee t) {
		
		int donorId=0;
      		
    	int tid=t.getTraineeId();
    	String tname=t.getTraineeName();
    	String tdom=t.getTraineeDomain();
    	String tloc=t.getTraineeLocation();
    	
    	String insertSql="INSERT INTO Trainee VALUES(?,?,?,?)";
    	Object[] params=new Object[]{tid,tname,tdom,tloc};
    	
    	int inserted=getJdbcTemplate().update(insertSql,params);    	
    	System.out.println(inserted);
    	
    	return donorId;
	}

	@Override
	public boolean isValidTrainee(int tid) {
		boolean status=false;
		System.out.println("TraineeId="+tid);
    	String sql="SELECT * FROM trainee WHERE traineeId=?";
		Object[] params=new Object[]{tid};
		int iStatus= getJdbcTemplate().update(sql,params);
		if(iStatus>0)
		{
			status=true;
		}
		
		return status;
	}

	@Override
	public Trainee viewTraineeById(int pid) {
		
		String sql="SELECT * FROM trainee WHERE traineeid=?";
	       Object[] params=new Object[]{pid};
	       TraineeMapper mapper=new TraineeMapper();
		  Trainee tDetail=(Trainee)getJdbcTemplate().queryForObject(sql,mapper,params);
	     return tDetail;
	}

	@Override
	public List<Trainee> viewAllTrainees() {
		
		String sql="SELECT * FROM trainee";
		  TraineeMapper mapper=new TraineeMapper();
		  List<Trainee> list=getJdbcTemplate().query(sql,mapper);
	     return list;
	}

	@Override
	public int deleteTrainee(int pid) {
	
		String sql="Delete from trainee where traineeid=?";   
		Object[] params=new Object[]{pid};
		
		int count= getJdbcTemplate().update(sql, params);			
		return count;
	}

	@Override
	public boolean isValidAdmin(Login login) {

		boolean userPresent=false;
		
		String sql = "SELECT count(*) from Login where loginid=? AND password=?";
		int count=(int)getJdbcTemplate().queryForInt(sql,login.getUserName(),login.getPassword());
		if(count==1)
		  userPresent=true;
		else
	      userPresent=false;		
			
		return userPresent;
	}

	@Override
	public List<Domain> getDomain() {
		String sql="select * from domain";
		List<Domain> co=getJdbcTemplate().query(sql,new DomainMapper());
		System.out.println(co);
		return co;
	}

	@Override
	public int updateTrainee(Trainee pid) {
		String sql="update trainee set traineename=?,traineedomain=?,traineelocation=? where traineeid=?";   
		Object[] params=new Object[]{pid.getTraineeName(),pid.getTraineeDomain(),pid.getTraineeLocation(),pid.getTraineeId()};
		
		int tDetail=getJdbcTemplate().update(sql, params);			
		return tDetail;
	}
	

}
