package com.cg.mps.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;




import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.mps.dto.MobileDTO;
import com.cg.mps.dto.PurchaseDTO;
import com.cg.mps.exception.MobileException;
import com.cg.mps.util.DbConnection;

public class MobileDao implements IMobileDao
{
	Logger logger=Logger.getLogger(MobileDao.class);
	
	
	public MobileDao()
	{
		PropertyConfigurator.configure("resources/log4j.properties");
	}
	
	
	@Override
	public int insertCustdetails(PurchaseDTO p) throws MobileException
	{
		
		logger.info("Inserting book details ...."+p);
		
		
		int purId=0;
		Connection conn=null;
		PreparedStatement ps=null;
		try {
	
			conn = DbConnection.getConnection();
		ps = conn.prepareStatement("INSERT INTO purchasedetails"
				+ " VALUES(purchaseId_seq.nextval,?,?,?,sysdate,?)");
	
	ps.setString(1, p.getCname());
	ps.setString(2, p.getMailId());
	ps.setString(3,p.getPhnNo());
	ps.setInt(4, p.getMobileId());
	
	
	ps.executeUpdate();
	
	Statement st=conn.createStatement();
	ResultSet rs=st.executeQuery("SELECT purchaseId_seq.currval FROM dual");
	
	if(rs.next())
	{
		purId=rs.getInt(1);
	}
	
	logger.info("Inserted Successfully ...."+purId);
	
	} catch (SQLException e) {
		logger.error("Error while Inserting ...."+e.getMessage());
			throw new MobileException(e.getMessage());
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
				throw new MobileException(se.getMessage());
				//Throw User defined exception here
			}
		}
    return purId;
	}
	
@Override
	public int updateMobile() throws MobileException
	{
	logger.info("Updating mobile details ....");
	Connection conn=null;
	PreparedStatement ps=null;
	PreparedStatement ps1=null;
	int count=0;
	int mid=0;
	int counter=0;
	try
	{

		conn = DbConnection.getConnection();
	ps = conn.prepareStatement("SELECT COUNT(mobileid),mobileid FROM purchasedetails GROUP BY mobileId");


    ResultSet rs=ps.executeQuery();

    while(rs.next())
    {
    	count=rs.getInt(1);
    	mid=rs.getInt(2);
    	ps1= conn.prepareStatement("UPDATE mobiles SET quantity=quantity-? WHERE mobileid=?");
    	ps1.setInt(1, count);
    	ps1.setInt(2, mid);
    	counter=ps1.executeUpdate();
    	
    }
    
    logger.info("Updation Successfull id is  ...."+mid);
    return counter;
	} 
	

    catch (SQLException e) {
    	logger.error("Error while updating ...."+e.getMessage());
		throw new MobileException(e.getMessage());
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
			throw new MobileException("Get "+se.getMessage());
			//Throw User defined exception here
		}
	}
		
	
	
	
	}

	@Override
	public ArrayList<MobileDTO> getAllDetails() throws MobileException
	{
		logger.info("Fetching all Mobiles...");
		
		ArrayList<MobileDTO> mobile=new ArrayList<MobileDTO>();
		Connection conn=null;
		PreparedStatement ps=null;
		try {
	
			conn = DbConnection.getConnection();
		ps = conn.prepareStatement("SELECT * FROM mobiles");

	
	    ResultSet rs=ps.executeQuery();
	
	    while(rs.next())
	    {
	    	MobileDTO mob=new MobileDTO();
	    	mob.setMobId(rs.getInt(1));
	    	mob.setName(rs.getString(2));
	    	mob.setPrice(rs.getFloat(3));
	    	mob.setQuantity(rs.getString(4));
		    mobile.add(mob);
	    }
	} catch (SQLException e) {
		logger.error("Error while fetching ...."+e.getMessage());
			throw new MobileException(e.getMessage());
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
				throw new MobileException("Get "+se.getMessage());
				//Throw User defined exception here
			}
		}
		logger.info(mobile.size()+" mobile(s) fetched");
		logger.info("----Mobile  Details---");
		logger.info(mobile);
    return mobile;
	}
		
		
		
		
	

	@Override
	public int deleteMobile(int id) throws MobileException {
		
		logger.info("deleting a mobile with"+id);
		//int delId=0;
		Connection conn=null;
		PreparedStatement ps=null;
		int count=0;
		try {
	
			conn = DbConnection.getConnection();
		ps = conn.prepareStatement("DELETE FROM mobiles WHERE mobileId=?");
	
	ps.setInt(1,id);
	ResultSet rs=ps.executeQuery();

	if(rs.next())
	{
		count++;
		
	}
	logger.info("Number of deleted records is ...."+count);
	}
		catch (SQLException e) {
			logger.error("Error while deleting ...."+e.getMessage());
			throw new MobileException(e.getMessage());
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
				throw new MobileException(se.getMessage());
				//Throw User defined exception here
			}
		}

		return count;
		
		
	}
	
	//Checking whether mobile 
	
	@Override
	public boolean isMobile(int id) throws MobileException {
		
		logger.info("Checking if mobile with "+id+" exists...");
		
		Connection conn=null;
		PreparedStatement ps=null;
		PreparedStatement ps2=null;
		
		int count=0;
		int qty=0;
		boolean status=false;
		try {
	
			conn = DbConnection.getConnection();
		ps = conn.prepareStatement("SELECT count(*) FROM mobiles WHERE mobileid=?");
		ps2=conn.prepareStatement("SELECT quantity FROM mobiles WHERE mobileid=?");
	
	ps.setInt(1,id);
	ps2.setInt(1,id);
	
	
	ResultSet rs=ps.executeQuery();
	ResultSet rs2=ps2.executeQuery();
	
	
	
	if(rs.next())
	{
		count=rs.getInt(1);
	}
	if(rs2.next())
	{
		 qty=rs.getInt(1);
	}
	
	if (count>0 && qty>0)
		status=true;
	else status=false;
	} catch (SQLException e) {
		logger.error("Error while checking ...."+e.getMessage());
			throw new MobileException(e.getMessage());
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
				throw new MobileException("isValid "+se.getMessage());
				//Throw User defined exception here
			}
		}
		logger.info("Mobile  exists status :"+status);
    return status;
	}

	@Override
	public ArrayList<MobileDTO> getMobileByRange(int min, int max)
			throws MobileException 
	{
		
		
		logger.info("Fetching all Mobiles between "+min+" and "+max);
		ArrayList<MobileDTO> mobile=new ArrayList<MobileDTO>();
		Connection conn=null;
		PreparedStatement ps=null;
		try {
	
			conn = DbConnection.getConnection();
		ps = conn.prepareStatement("SELECT * FROM mobiles where price>? AND price<?");
		ps.setInt(1,min);
		ps.setInt(2, max);

	
	    ResultSet rs=ps.executeQuery();
	
	    while(rs.next())
	    {
	    	MobileDTO mob=new MobileDTO();
	    	mob.setMobId(rs.getInt(1));
	    	mob.setName(rs.getString(2));
	    	mob.setPrice(rs.getFloat(3));
	    	mob.setQuantity(rs.getString(4));
		    mobile.add(mob);
	    }
	} catch (SQLException e) {
		logger.error("Error while fetching ...."+e.getMessage());
			throw new MobileException(e.getMessage());
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
				throw new MobileException("Get "+se.getMessage());
				//Throw User defined exception here
			}
		}
		logger.info(mobile.size()+" mobile(s) fetched");
		logger.info("----Mobile  Details---");
		logger.info(mobile);
    return mobile;
    

		

	}
	
	
	
	

}
