package com.cg.proj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.proj.util.DbConnection;
import com.cg.proj.beam.ProjectDto;
import com.cg.proj.exception.ProjectException;


public class ProjectDao implements IProjectDao{
	
	Logger logger=Logger.getLogger(ProjectDao.class);
	
	public ProjectDao()
	{
		PropertyConfigurator.configure("resources/log4j.properties");
	}

	@Override
	public int insertProject(ProjectDto project) throws ProjectException {
		//Connection to the DB
		logger.info("Inserting Project details of mobile...."+project);
				
		int projectcode=0;
		Connection conn=null;
		PreparedStatement ps=null;
					
		try {
				
			conn = DbConnection.getConnection();
			ps = conn.prepareStatement("INSERT INTO project VALUES(project_seq.nextval,?,?,?,sysdate)");
						
			ps.setString(1,project.getProjectName());
			ps.setInt(2,project.getDuration());
			ps.setInt(3,project.getNoOfResources());
				
			ps.executeUpdate();
				
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("SELECT project_seq.currval FROM dual");
				
			if(rs.next())
				{
				projectcode=rs.getInt(1);
				}
			logger.info("Inserted Successfully ...."+projectcode);	
			} 
		catch (SQLException e)
		{
			logger.error("Error while Inserting ...."+e.getMessage());
			throw new ProjectException(e.getMessage());
		}
					finally
					{
						try
						{
							conn.close();
							ps.close();
						}
						catch(SQLException se)
						{
							throw new ProjectException(se.getMessage());
							//Throw User defined exception here
						}
					}
			    return projectcode;		
	}

	@Override
	public ProjectDto viewById(int ProjectId) throws ProjectException {
		logger.info("viewing projects by proj id...."+ProjectId);
		ProjectDto proj=new ProjectDto();
		Connection conn=null;
		PreparedStatement ps=null;
		try {
	
			conn = DbConnection.getConnection();
		ps = conn.prepareStatement("SELECT * FROM project where pcode=?");
				
		ps.setInt(1,ProjectId);
	
	    ResultSet rs=ps.executeQuery();
	
	    if(rs.next())
	    {
	    	proj.setProjectCode(rs.getInt(1));
	    	proj.setProjectName(rs.getString(2));
	    	proj.setDuration(rs.getInt(3));
	    	proj.setNoOfResources(rs.getInt(4));
	    	proj.setStratDate(rs.getDate(5));
	    	logger.info("view Successful ...."+ProjectId);	
	    }
	} catch (SQLException e) {
		logger.error("Error while viewing ...."+e.getMessage());
			throw new ProjectException(e.getMessage());
		}
		finally
		{
			try
			{
				conn.close();
				ps.close();
			}
			catch(SQLException se)
			{
				throw new ProjectException("Get "+se.getMessage());
				//Throw User defined exception here
			}
		}
    return proj;
	}

	@Override
	public ArrayList<ProjectDto> viewAllProject() throws ProjectException {
		logger.info("Fetching all projects...");
		ArrayList<ProjectDto> projects=new ArrayList<ProjectDto>();
		Connection conn=null;
		PreparedStatement ps=null;
		try {
	
			conn = DbConnection.getConnection();
		ps = conn.prepareStatement("SELECT * FROM project");

	
	    ResultSet rs=ps.executeQuery();
	
	    while(rs.next())
	    {
	    	ProjectDto p=new ProjectDto();
	    	p.setProjectCode(rs.getInt(1));
	    	p.setProjectName(rs.getString(2));
	    	p.setDuration(rs.getInt(3));
	    	p.setNoOfResources(rs.getInt(4));
	    	p.setStratDate(rs.getDate(5));
	    	
	    	projects.add(p);
	    }
	} catch (SQLException e) {
		logger.error("Error while getting projects ...."+e.getMessage());
			throw new ProjectException(e.getMessage());
		}
		finally
		{
			try
			{
				conn.close();
				ps.close();
			}
			catch(SQLException se)
			{
				throw new ProjectException("Get "+se.getMessage());
				//Throw User defined exception here
			}
		}
		
		logger.info(projects.size()+" mobiles(s) fetched");
		logger.info("----project Details---");
		logger.info(projects);
    return projects;
		
	}

	@Override
	public boolean deleteProject(int ProjectId) throws ProjectException {
		logger.info("deleting the mobile by id ...."+ProjectId);
		int count1=0;
		boolean status=false;
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			
			conn = DbConnection.getConnection();
		ps = conn.prepareStatement("DELETE FROM project WHERE pcode=?");
		ps.setInt(1,ProjectId);
	    count1=ps.executeUpdate();
	    System.out.println(count1+"rows deleted from project"+ProjectId);
	    if(count1!=0)
	    {
	    	status=true;
	    }
	    else
	    {
	    	status=false;
	    }
	   
	   logger.info("Deleted Successfully ...."+ProjectId);
		}
		catch (SQLException e) {
			logger.error("Error while deleting ...."+e.getMessage());
			throw new ProjectException(e.getMessage());
		}
		finally
		{
			try
			{
				conn.close();
				ps.close();
			}
			catch(SQLException se)
			{
				throw new ProjectException("Get "+se.getMessage());
				//Throw User defined exception here
			}
		}
   
		return status;
	}

	@Override
	public boolean isProject(int id) throws ProjectException {
		logger.info("Checking if project with "+id+" exists...");
		Connection conn=null;
		PreparedStatement ps=null;
		int count=0;
		boolean status=false;
		try {
	
			conn = DbConnection.getConnection();
		ps = conn.prepareStatement("SELECT count(*) FROM project WHERE pcode=?");
	
	ps.setInt(1,id);
	
	
	ResultSet rs=ps.executeQuery();
	
	
	if(rs.next())
	{
		count=rs.getInt(1);
	}
	if (count>0)
		status=true;
	else status=false;
	} catch (SQLException e) {
		logger.error("Error while checking project is there or not ...."+e.getMessage());
			throw new ProjectException(e.getMessage());
		}
		finally
		{
			try
			{
				conn.close();
				ps.close();
			}
			catch(SQLException se)
			{
				throw new ProjectException("isValid "+se.getMessage());
				//Throw User defined exception here
			}
		}
		logger.info("project exists status :"+status);
    return status;
	}

	@Override
	public HashMap<Integer, ProjectDto> viewAllProjectHash()
			throws ProjectException {
		logger.info("Fetching all projects...");
		HashMap<Integer,ProjectDto> projects=new HashMap<Integer,ProjectDto> ();
		Connection conn=null;
		PreparedStatement ps=null;
		try {
	
			conn = DbConnection.getConnection();
		ps = conn.prepareStatement("SELECT * FROM project");

	
	    ResultSet rs=ps.executeQuery();
	
	    while(rs.next())
	    {
	    	ProjectDto p=new ProjectDto();
	    	p.setProjectCode(rs.getInt(1));
	    	p.setProjectName(rs.getString(2));
	    	p.setDuration(rs.getInt(3));
	    	p.setNoOfResources(rs.getInt(4));
	    	p.setStratDate(rs.getDate(5));
	    	
	    	projects.put(p.getProjectCode(), p);
	    }
	} catch (SQLException e) {
		logger.error("Error while getting projects ...."+e.getMessage());
			throw new ProjectException(e.getMessage());
		}
		finally
		{
			try
			{
				conn.close();
				ps.close();
			}
			catch(SQLException se)
			{
				throw new ProjectException("Get "+se.getMessage());
				//Throw User defined exception here
			}
		}
		
		logger.info(projects.size()+" mobiles(s) fetched");
		logger.info("----project Details---");
		logger.info(projects);
    return projects;
	
	}

}
