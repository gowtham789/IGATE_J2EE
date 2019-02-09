package com.igate.bms.dto;
/*
 * CREATE TABLE Book_Java
( BookId NUMBER(4),
  bookname VARCHAR2(10),
  Author VARCHAR2(10),
  price NUMBER(6,2)
);
 */
public class BookDTO {

	private int bookCode;
	private String bookName;
	private String author;
	private float price;
	
	public BookDTO(int bookCode, String bookName, String author, float price)
	{
		super();
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.author = author;
		this.price = price;
	}
	public BookDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getBookCode() {
		return bookCode;
	}
	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "BookDTO [bookCode=" + bookCode + ", bookName=" + bookName
				+ ", author=" + author + ", price=" + price + "]";
	}
	
}
