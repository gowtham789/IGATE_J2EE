package com.igate.bms.service;

import java.util.ArrayList;

import com.igate.bms.dao.BookDao;
import com.igate.bms.dto.BookDTO;
import com.igate.bms.exception.BookException;

public class BookService implements IBookService {

	BookDao bdao=new BookDao();
	@Override
	public int insertBook(BookDTO b) throws BookException {
		int bid=bdao.insertBook(b);
		return bid;
	}

	@Override
	public BookDTO getBookById(int id) throws BookException{
		return bdao.getBookById(id);
	}

	@Override
	public boolean isBook(int id) throws BookException {
		return bdao.isBook(id);
		
	}

	@Override
	public ArrayList<BookDTO> getAllBooks() throws BookException {
		return bdao.getAllBooks();
	}

}
