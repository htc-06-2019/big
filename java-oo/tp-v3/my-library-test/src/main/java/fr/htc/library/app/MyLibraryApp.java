package fr.htc.library.app;

import java.util.List;

import javax.print.attribute.standard.PrinterLocation;

import fr.htc.library.model.Book;
import fr.htc.library.services.book.BookService;
import fr.htc.library.services.book.BookServiceImpl;
import fr.htc.library.services.borrow.BorrowService;
import fr.htc.library.services.borrow.BorrowServiceImpl;
import fr.htc.library.services.member.MemberService;
import fr.htc.library.services.member.MemberServiceImpl;

@SuppressWarnings("unused")
public class MyLibraryApp {

	public static void main(String[] args) {
		// insert books
		BookService bookService = new BookServiceImpl();
		String title = "Ce que le jours doit à la nuit";
		String author = "Yasmina KHADRA";
		int year = 2000;
		
		bookService.create(title, author, year);
		bookService.create(title, author, year);
		bookService.create(title, author, year);
		bookService.create(title, author, year);
		bookService.create(title, author, year);
		
		//insert members
		MemberService memberService = new MemberServiceImpl();
		String firstName = "Djamel";
		String lastName = "MOUCHENE";
		int age = 25;
		memberService.create(firstName, lastName, age);
		memberService.create(firstName, lastName, age);
		
		
		//make usecases
		String cote1 = "YA00-10";
		String cote2 = "YA00-11";
		String cote3 = "YA00-12";
		String cote4 = "YA00-13";
		String cote5 = "YA00-14";
		
		String matricule1 = "MD100";
		String matricule2 = "MD101";
		BorrowService borrowService = new BorrowServiceImpl();
		
		borrowService.checkout(matricule1, cote1);
		borrowService.checkout(matricule2, cote2);
		borrowService.checkIn(matricule1, cote2);
		
		
		/*
		borrowService.checkout(matricule1, cote2);
		borrowService.checkout(matricule1, cote3);
		borrowService.checkout(matricule1, cote4);
		
		borrowService.checkout(matricule2, cote4);
		
		borrowService.checkIn(matricule1, cote1);
		
		borrowService.checkout(matricule2, cote1);
		borrowService.checkout(matricule1, cote5);
		
		borrowService.checkIn(matricule1, cote2);
		borrowService.checkIn(matricule1, cote3);
		borrowService.checkIn(matricule1, cote5);
		borrowService.checkIn(matricule1, cote1);
		borrowService.checkIn(matricule2, cote4);
		*/
		List<Book>  availableBooks = bookService.getAvailableBooks();
		List<Book>  borrowdBooks = bookService.getBorrowedBooks();
		
		System.out.println(" ************  Livres dipos  ************");
		for (Book book : availableBooks) {
			System.out.println(book);
		}		
		System.out.println(" ************  Livres dipos  ************");
		
		System.out.println(" ************  Livres NON  dipos  ************");
		for (Book book : borrowdBooks) {
			System.out.println(book);
		}		
		System.out.println(" ************  Livres NON dipos  ************");
		
		
		System.out.println(memberService.findByMatricule(matricule1));
		System.out.println(memberService.findByMatricule(matricule2));
		

	}

}
