package com.cg.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;




import org.apache.log4j.Logger;


import org.apache.log4j.PropertyConfigurator;

import com.cg.pms.util.DbConnection;
import com.cg.pms.dto.ProjectDTO;
import com.cg.pms.exception.ProjectException;




public class ProjectDao implements IProjectDao{
	
	Logger logger=Logger.getLogger(ProjectDao.class);
	
	public ProjectDao()
	{
		PropertyConfigurator.configure("resources/log4j.properties");
	}
	

	@Override
	public int insertProject(ProjectDTO p) throws ProjectException {
		
		logger.info("Inserting Project details ...."+p);
		
		int pId=0;
		Connection conn=null;
		PreparedStatement ps=null;
		try {
	
			conn = DbConnection.getConnection();
		ps = conn.prepareStatement("INSERT INTO project"
				+ " VALUES(project_seq.nextval,?,?,?,sysdate)");
	
	ps.setString(1, p.getProjectName());
	ps.setInt(2, p.getDuration());
	ps.setInt(3,p.getNoOfResources());
	
	ps.executeUpdate();
	
	Statement st=conn.createStatement();
	ResultSet rs=st.executeQuery("SELECT project_seq.currval FROM dual");
	
	if(rs.next())
	{
		pId=rs.getInt(1);
	}
	logger.info("Inserted Successfully ...."+pId);
	}
		catch (SQLException e) {
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
    return pId;
	}

	
	//Viewing project details by id

	@Override
	public ProjectDTO viewById(int projectId) throws ProjectException {
		logger.info("Fetching  Project details by ID...."+projectId);
		ProjectDTO p=new ProjectDTO();
		Connection conn=null;
		PreparedStatement ps=null;
		try {
	
			conn = DbConnection.getConnection();
		ps = conn.prepareStatement("SELECT * FROM project"
				+ " WHERE projectid=?");
		ps.setInt(1, projectId);
	
	    ResultSet rs=ps.executeQuery();
	
	    if(rs.next())
	    {
		 p.setProjectCode(rs.getInt(1));
		 p.setProjectName(rs.getString(2));
		 p.setDuration(rs.getInt(3));
		 p.setNoOfResources(rs.getInt(4));
		 p.setStartdate(rs.getDate(5));
	    }
	    logger.info("Project details ...."+p);
	} catch (SQLException e) {
		logger.info("Error while fetching project details ...."+projectId);
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
    return p;
	}
	
	
	//Fetching Project Details

	@Override
	public ArrayList<ProjectDTO> viewAllProjects() throws ProjectException {
		
		logger.info("Fetching  Project details ...");
		
		ArrayList<ProjectDTO> project=new ArrayList<ProjectDTO>();
		Connection conn=null;
		PreparedStatement ps=null;
		try {
	
			conn = DbConnection.getConnection();
		ps = conn.prepareStatement("SELECT * FROM project");

	
	    ResultSet rs=ps.executeQuery();
	
	    while(rs.next())
	    {
	    	ProjectDTO p=new ProjectDTO();
	    	 p.setProjectCode(rs.getInt(1));
			 p.setProjectName(rs.getString(2));
			 p.setDuration(rs.getInt(3));
			 p.setNoOfResources(rs.getInt(4));
			 p.setStartdate(rs.getDate(5));
		 project.add(p);
	    }
	} catch (SQLException e) {
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
		logger.info(project.size()+" project(s) fetched");
		logger.info("----Project Details---");
		logger.info(project);
    return project;
	}
	
	

	@Override
	public boolean deleteProject(int projectId) throws ProjectException 
	{
		logger.info("Deleting  Project details with ID..."+projectId);
		
		Connection conn=null;
		PreparedStatement ps=null;
		int count=0;
		boolean status=false;
		try {
	
			conn = DbConnection.getConnection();
		ps = conn.prepareStatement("DELETE FROM project WHERE projectid=?");
	
	ps.setInt(1,projectId);
	ResultSet rs=ps.executeQuery();

	if(rs.next())
	{
		count++;
		
	}
	if (count>0)
		status=true;
	else status=false;
	logger.info("Number of deleted records is ...."+count);
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
				throw new ProjectException(se.getMessage());
				//Throw User defined exception here
			}
		}
		
		return status;
		
		
	}

	
	//Checking whether the project is present
	@Override
	public boolean isProject(int projectId) throws ProjectException
	{
		logger.info("Checking if project with "+projectId+" exists...");
		Connection conn=null;
		PreparedStatement ps=null;
		PreparedStatement ps2=null;
		
		int count=0;
	
		boolean status=false;
		try {
	
			conn = DbConnection.getConnection();
		ps = conn.prepareStatement("SELECT count(*) FROM project WHERE projectid=?");
		ps.setInt(1,projectId);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			count=rs.getInt(1);
		}
		if (count>0)
			status=true;
		else status=false;
		} 
		catch (SQLException e) {
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
		logger.info("Project exists status :"+status);
	    return status;
		
	}

	
	

	

}
