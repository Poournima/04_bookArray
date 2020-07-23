package com.montran.main;

import java.util.Scanner;

import com.montran.pojo.Book;
import com.montran.util.BookUtil;

public class BookMainV1 {
	

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int bookId;
		String name;
		double price;
		int bookChoice;
		String choice;
		boolean result;
		int numberOfBooks;
		
		BookUtil bookutil=new BookUtil(100);
		Book  books[]=null;
		Book book;
		Book book1[];
		
		do {
			
			book1=bookutil.getAllBooks();
			
			for(Book allbook :book1)
			{
				if(allbook != null) {
					System.out.println("Book Details::");
					System.out.println("Book ID\t Book Name \t Book Price");
					System.out.println(allbook.getBookId()+ "\t"+allbook.getName()+ "\t" +allbook.getPrice());
					
				}
			}
			
		System.out.println("Menu");
		System.out.println("1.Add single Book");
		System.out.println("2.Add Multiple Book");
		System.out.println("3.Update Existing Book");
		System.out.println("4.Delete Existing Book");
		System.out.println("5.Single Book Details");
		System.out.println("6.Exit");
		
		System.out.println("Enter your choice");
		bookChoice=scanner.nextInt();
		
		switch (bookChoice) {
		case 1:
			System.out.println("Enter Book ID::");
			bookId=scanner.nextInt();
			System.out.println("Enter Book Name::");
			name=scanner.next();
			System.out.println("Enter Book Price:: ");
			price=scanner.nextDouble();
			book=new Book(0,name,price);
			result=bookutil.addNewBook(book);
			if(result) 
				System.out.println("Book is added successfully ");
				else
				System.out.println("Fail to add book");
				break;
		case 2:
			System.out.println("How Many Books");
			numberOfBooks=scanner.nextInt();
			if(numberOfBooks<(bookutil.getMaxValue()-bookutil.getNextValue()))
			{
				
				book1=new Book[numberOfBooks];
				for(int i=0;i<numberOfBooks;i++){
				System.out.println("Enter Book ID::");
				bookId=scanner.nextInt();
				System.out.println("Enter Book Name::");
				name=scanner.next();
				System.out.println("Enter Book Price:: ");
				price=scanner.nextDouble();
					
				book=new Book(0,name,price);
				book1[i]=book;
				}
				result=bookutil.addAllBooks(books);
				System.out.println("Book Added Successfully");
				
			}
			else
			{
				System.out.println("No space ");
			}
			break;
		case 3:
			System.out.println("Enter BookId");
			bookId = scanner.nextInt();
			book = bookutil.getBookByBookId(bookId);
			if (book != null) {
				System.out.println(book);
				System.out.println("Book New Name");
				name = scanner.nextLine();
				System.out.println("Book New Price");
				price = scanner.nextDouble();

				result = bookutil.updateBook(bookId, name, price);
				if (result)
					System.out.println("Book details are updated successfully !!");
				else
					System.out.println("Failed to update book details");
			} else
				System.out.println("No Book Found !!");
			break;
			
		case 4:
			System.out.println("Enter BookId");
			bookId = scanner.nextInt();
			book = bookutil.getBookByBookId(bookId);
			if (book != null) {
				result = bookutil.deleteBook(bookId);
				if (result)
					System.out.println("Book deleted successfully ");
				else
					System.out.println("Failed to delete book");
			} else
				System.out.println("No Book Found !!");
			break;
		case 5:
			System.out.println("Enter BookId");
			bookId = scanner.nextInt();
			book = bookutil.getBookByBookId(bookId);
			if (book != null) {
				System.out.println(book);
			} else
				System.out.println("No Book Found !!");
			break;
		case 6:
			System.out.println("Thank you");
			break;
		default:
			break;
		}
		System.out.println("Do you want to Continue");
		choice=scanner.next();
		
		}while(choice.equals("yes")); 
			
		
	}

}
