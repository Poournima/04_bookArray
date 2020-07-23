package com.montran.util;

import com.montran.pojo.Book;

public class BookUtil {
	 private Book books[];
	 
	int nextValue=0;
	int maxValue;
	
	public int getNextValue() {
		return nextValue;
	}
	public int getMaxValue() {
		return maxValue;
	}
	public BookUtil(int booksNumber) {
		books=new Book[booksNumber];
		maxValue=booksNumber;
		
	}
	public boolean addNewBook(Book book) {
		if(nextValue >=0 && nextValue < maxValue)
		{
			books[nextValue]=book;
			nextValue++;
			return true;
		}

		return false;
		
	}
	public boolean addAllBooks(Book[] books) {
		for(Book book:books) {
		if(nextValue >=0 && nextValue < maxValue)
		{
			books[nextValue]=book;
			nextValue++;
			return true;
		}
		}
		return false;
		
	}
	public boolean  updateBook(int bookid, String newName, double price) {
		for(Book book:books) {
			if(book.getBookId()==bookid) {
				book.setBookId(bookid);
				book.setName(newName);
				book.setPrice(price);
			}
		}
		return false;
		
	}
	public boolean  deleteBook(int bookId) {
		for(int i=0;i<books.length;i++)
		{
			if(books[i].getBookId()==bookId) {
				for(int j=i;j<maxValue-1;j++) {
					books[j]=books[j+1];
					return true;
				}
			}
			
		}
		return false;
		
	}
	public Book getBookByBookId(int bookid) {
		for(Book book:books)
		{
			if(book != null) {
				
			
			if(book.getBookId()==bookid)
			{
				return book;	
			}
			}
		}
		return null;
		
	}
	public Book[] getAllBooks()
	{
		return books;
		
	}

}
