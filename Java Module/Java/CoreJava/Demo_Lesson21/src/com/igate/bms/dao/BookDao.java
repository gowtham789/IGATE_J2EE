package com.igate.bms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.igate.bms.dto.BookDTO;
import com.igate.bms.exception.BookException;
import com.igate.bms.util.DbConnection;



public class BookDao  implements IBookDao{

	Logger logger=Logger.getLogger(BookDao.class);
	
	public BookDao()
	{
		PropertyConfigurator.configure("resources/log4j.properties");
	}
	@Override
	public int insertBook(BookDTO b) throws BookException {
		//Connection to the DB
		
		logger.info("Inserting book details ...."+b);
		int bookId=0;
		Connection conn=null;
		PreparedStatement ps=null;
		try {
	
			conn = DbConnection.getConnection();
		ps = conn.prepareStatement("INSERT INTO book_java"
				+ " VALUES(bookId_seq.nextval,?,?,?)");
	
	ps.setString(1, b.getBookName());
	ps.setString(2, b.getAuthor());
	ps.setFloat(3,b.getPrice());
	
	ps.executeUpdate();
	
	Statement st=conn.createStatement();
	ResultSet rs=st.executeQuery("SELECT bookId_seq.currval FROM dual");
	
	if(rs.next())
	{
		bookId=rs.getInt(1);
	}
	logger.info("Inserted Successfully ...."+bookId);
	} catch (SQLException e) {
		logger.error("Error while Inserting ...."+e.getMessage());
			throw new BookException(e.getMessage());
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
				throw new BookException(se.getMessage());
				//Throw User defined exception here
			}
		}
    return bookId;
	}

	
	//getting book by Id
	@Override
	public BookDTO getBookById(int id) throws BookException{

		logger.info("Fetching book details ...."+id);
		BookDTO book=new BookDTO();
		Connection conn=null;
		PreparedStatement ps=null;
		try {
	
			conn = DbConnection.getConnection();
		ps = conn.prepareStatement("SELECT * FROM book_java"
				+ " WHERE bookId=?");
		ps.setInt(1, id);
	
	    ResultSet rs=ps.executeQuery();
	
	    if(rs.next())
	    {
		 book.setBookCode(rs.getInt(1));
		 book.setBookName(rs.getString(2));
		 book.setAuthor(rs.getString(3));
		 book.setPrice(rs.getFloat(4));
	    }
	    logger.info("Book details ...."+book);
	} catch (SQLException e) {
		logger.info("Error while fetching book details ...."+id);
			throw new BookException(e.getMessage());
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
				throw new BookException("Get "+se.getMessage());
				//Throw User defined exception here
			}
		}
    return book;
	}

	
	//Checking whether a book Id exist
	@Override
	public boolean isBook(int id) throws BookException{
		
		logger.info("Checking if book with "+id+" exists...");
		int bookId=0;
		Connection conn=null;
		PreparedStatement ps=null;
		int count=0;
		boolean status=false;
		try {
	
			conn = DbConnection.getConnection();
		ps = conn.prepareStatement("SELECT count(*) FROM book_java WHERE bookid=?");
	
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
			throw new BookException(e.getMessage());
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
				throw new BookException("isValid "+se.getMessage());
				//Throw User defined exception here
			}
		}
		logger.info("Book exists status :"+status);
    return status;
	}

	//Get all Books
	@Override
	public ArrayList<BookDTO> getAllBooks() throws BookException{
		logger.info("Fetching all books...");
		ArrayList<BookDTO> books=new ArrayList<BookDTO>();
		Connection conn=null;
		PreparedStatement ps=null;
		try {
	
			conn = DbConnection.getConnection();
		ps = conn.prepareStatement("SELECT * FROM book_java");

	
	    ResultSet rs=ps.executeQuery();
	
	    while(rs.next())
	    {
	     BookDTO book=new BookDTO();
		 book.setBookCode(rs.getInt(1));
		 book.setBookName(rs.getString(2));
		 book.setAuthor(rs.getString(3));
		 book.setPrice(rs.getFloat(4));
		 books.add(book);
	    }
	} catch (SQLException e) {
			throw new BookException(e.getMessage());
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
				throw new BookException("Get "+se.getMessage());
				//Throw User defined exception here
			}
		}
		
		logger.info(books.size()+" book(s) fetched");
		logger.info("----Book Details---");
		logger.info(books);
    return books;
	}

}
