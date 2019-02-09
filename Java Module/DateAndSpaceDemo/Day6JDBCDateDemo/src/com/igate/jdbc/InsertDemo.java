package com.igate.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import com.igate.dto.Exam;

public class InsertDemo {
	public static void main(String[] args) {
		// Loading the Driver
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");// Type 4 Driver

			// Get the Connection
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@172.28.40.3:1521:orcl", "hema",
					"hema76412");

			System.out.println("Connected :" + conn);

			/*
			 * CREATE TABLE exam (examCode NUMBER(3),course
			 * VARCHAR2(10),examDate DATE);
			 */

			// Create a Statement
			PreparedStatement st = conn
					.prepareStatement("INSERT INTO exam VALUES(?,?,?)");

			Exam e1 = new Exam();
			e1.setExamCode(144);
			e1.setCourse("VnV");
			e1.setDateOfExam(LocalDate.of(2003, 04, 14));

			st.setInt(1, e1.getExamCode());
			st.setString(2, e1.getCourse());
			st.setDate(3, Date.valueOf(e1.getDateOfExam()));
			int count = st.executeUpdate();
			System.out.println(count + " rows inserted");

			System.out.println("Selecting course details");
			Statement st2 = conn.createStatement();
			ResultSet rs = st2.executeQuery("SELECT * FROM exam");

			while (rs.next()) {
				Exam temp = new Exam();
				temp.setExamCode(rs.getInt(1));
				temp.setCourse(rs.getString(2));
				temp.setDateOfExam(rs.getDate(3).toLocalDate());
				System.out.println(temp);
			}

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());

		}
	}
}
