package com.igate.bms.dao;

import java.util.ArrayList;

import com.igate.bms.dto.BookDTO;
import com.igate.bms.exception.BookException;

public interface IBookDao {
	int insertBook(BookDTO b) throws BookException;
	BookDTO getBookById(int id) throws BookException;
	boolean isBook(int id) throws BookException;
	ArrayList<BookDTO> getAllBooks()throws BookException;
	/*
	 * int updateBook(int id,float newPrice);
	 * int deleteBook(int id);
	 */
}
