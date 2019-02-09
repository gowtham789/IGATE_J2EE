package com.igate.dto;

public class Book {
int bookCode;
String title;
String author;
float price;
public int getBookCode() {
	return bookCode;
}
public void setBookCode(int bookCode) {
	this.bookCode = bookCode;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
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
public Book(int bookCode, String title, String author, float price) {
	super();
	this.bookCode = bookCode;
	this.title = title;
	this.author = author;
	this.price = price;
}
public Book() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Book [bookCode=" + bookCode + ", title=" + title + ", author="
			+ author + ", price=" + price + "]";
}

}
