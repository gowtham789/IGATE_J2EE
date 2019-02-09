package com.igate.bms.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.igate.bms.dto.BookDTO;
import com.igate.bms.exception.BookException;
import com.igate.bms.service.BookService;

public class BookMain {

	public static void main(String[] args) {

		BookService bs=new BookService();
		Scanner sc=new Scanner(System.in);
		
		int choice;
		
		while(true)
		{
			System.out.println("Welcome to Book Management System");
			System.out.println(" 1 -> Insert a Book");
			System.out.println(" 2 -> Fetch a Book by Id");
			System.out.println(" 3 -> Display all Books");
			System.out.println(" 4 -> Exit");
			
			System.out.println(" ---------------------");
			System.out.println(" Enter your choice :");
			choice=sc.nextInt();	
			
			switch(choice)
			{
			case 1:
			{
				//Inserting a book
				// Create sequence BookId_Seq Start with 1000;
				
				BookDTO b1=new BookDTO();
				
				System.out.println("Enter the book Name :");
				b1.setBookName(sc.next());
				
				System.out.println("Enter the Author :");
				b1.setAuthor(sc.next());
				
				while(true)
				{
					System.out.println("Enter the Price :");
					float price=sc.nextFloat();
					if(price>100 && price <2000)
					{
					b1.setPrice(price);
					break;
					}
					else
					{
						System.err.println("Price Should be 100 - 2000");
					}
				}
				
				try
				{
				//Call the service layer to insert the book details
				int bookId=bs.insertBook(b1);
				if(bookId!=0)
				{
					System.out.println("Book Inserted Successfully Id is : "+bookId);
				}
				else
				{
					System.out.println("Sorry! Unable to insert the book");
				}
				}
				catch(BookException be)
				{
					System.out.println(be.getMessage());
				}
				break;
			}//End of Case 1
			case 2:
			{
				//Get book By Id
				System.out.println("Enter the book to search!");
				 int id=sc.nextInt();
				 boolean isValid;
				 try
				 {
				 isValid=bs.isBook(id);
				 
				 //If book is Valid
				 if(isValid)

				 {
					 BookDTO b=bs.getBookById(id);
					 System.out.println(b);
				 }
				 else
				 {
					 System.out.println("Sorry ! Invalid book Id...");
				 }
				 
				 }catch(BookException be)
					{
						System.out.println(be.getMessage());
					}
			break;
			}//End of Case 2
			
			case 3:
			{
				//Get book By Id
				System.out.println("Displaying all Books");
				ArrayList<BookDTO> bookList= new ArrayList<BookDTO>();
				 try
				 {
				
					 bookList=bs.getAllBooks();
					 if(bookList.size()==0)
					 {
					 System.out.println("Sorry! No books found...");
					 }
					 else
					 {
						 System.out.println("    Book Details     ");
						 System.out.println("-----------------------");
						 System.out.println("Id   Name    Author   Price");
						 
						 for(BookDTO b:bookList)
						 {
							 System.out.println(b.getBookCode()+"  "+b.getBookName()+" "+b.getAuthor()+" "+b.getPrice());
						 }
						 System.out.println(" ");
						 System.out.println("-----------------------");
					 }
				 
				 }catch(BookException be)
					{
						System.out.println(be.getMessage());
					}
			 break;
			}//End of Case 3
			case 4:{
				System.exit(0);
			}
			}
		}
		

	}

}
