package com.igate.munipal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.igate.munipal.dto.FirmMaster;
import com.igate.munipal.exception.FirmException;
import com.igate.munipal.util.ConnectionDB;

public class RegisterImplDAO implements RegisterDAO {
	Connection connection = null;
	PreparedStatement ps = null;
	Statement st = null;
	ResultSet rs = null;

	@Override
	// ***********************Method for insertion of data into
	// DataBase***********************
	public int InsertData(FirmMaster firm) throws FirmException {
		connection = ConnectionDB.getConnection();
		String insert = "INSERT INTO firms_master values(FIRMSId_Seq.nextVal,?,?,?,?,?)";
		int result = 0;
		try {
			ps = connection.prepareStatement(insert);
			ps.setString(1, firm.getOwnerName());
			ps.setString(2, firm.getBusinessName());
			ps.setString(3, firm.geteMail());
			ps.setString(4, firm.getMobileNo());
			ps.setString(5, firm.getIsActive());

			result = ps.executeUpdate();
		} catch (SQLException e) {
			throw new FirmException("Error while inserting data into DB"
					+ e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new FirmException("Error while closing DB Connection"
						+ e.getMessage());
			}
		}
		return result;
	}

	@Override
	// ***********************Method for activating
	// useraccount***********************
	public int activateData(FirmMaster master) throws FirmException {
		connection = ConnectionDB.getConnection();
		String update = "UPDATE firms_master set isactive=? where email=?";
		int result = 0;

		try {
			ps = connection.prepareStatement(update);
			ps.setString(1, master.getIsActive());
			ps.setString(2, master.geteMail());
			result = ps.executeUpdate();
		} catch (SQLException e) {

			throw new FirmException("Error while activating account"
					+ e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {

				throw new FirmException("Error while closing DB Connection"
						+ e.getMessage());
			}
		}

		return result;
	}

}
