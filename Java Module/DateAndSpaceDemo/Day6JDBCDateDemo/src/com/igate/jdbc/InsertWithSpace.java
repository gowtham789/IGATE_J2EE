package com.igate.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.igate.dto.Book;

public class InsertWithSpace {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");// Type 4 Driver

			// Get the Connection
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@172.28.40.3:1521:orcl", "hema",
					"hema76412");

			System.out.println("Connected :" + conn);

			/*
			 * CREATE TABLE books (bookCode NUMBER(3),title VARCHAR2(10),author
			 * VARCHAR2(10),price NUMBER(7,2));
			 */

			// Create a Statement
			PreparedStatement st = conn
					.prepareStatement("INSERT INTO books VALUES(?,?,?,?)");

			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			Scanner sc = new Scanner(System.in);
			
			Book b1 = new Book();
			System.out.println("Enter the book code");
			int bcode = sc.nextInt();
			b1.setBookCode(bcode);

			System.out.println("Enter the title");
			String bookname = br.readLine();
			
			b1.setTitle(bookname);

			System.out.println("Enter the author");
			String author = br.readLine();
			b1.setAuthor(author);

			System.out.println("Enter the price");
			float price = sc.nextFloat();
			b1.setPrice(price);

			st.setInt(1, b1.getBookCode());
			st.setString(2, b1.getTitle());
			st.setString(3, b1.getAuthor());
			st.setFloat(4, b1.getPrice());

			int count = st.executeUpdate();
			System.out.println(count + " Rows Inserted ");
			
			Statement st2=conn.createStatement();
			ResultSet rs=st2.executeQuery("SELECT * FROM books");
			
			while(rs.next())
			{
				Book b=new Book();
				b.setBookCode(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getFloat(4));
				
				System.out.println(b);
			}

		} catch (ClassNotFoundException | SQLException | IOException e) {
			System.out.println(e.getMessage());

		}

	}

}
