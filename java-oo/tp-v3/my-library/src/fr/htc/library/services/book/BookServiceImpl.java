package fr.htc.library.services.book;

import java.util.ArrayList;
import java.util.List;

import fr.htc.library.dao.book.BookDao;
import fr.htc.library.dao.book.BookDaoMapImpl;
import fr.htc.library.model.Book;

public class BookServiceImpl implements BookService {

	private BookDao bookDao = new BookDaoMapImpl();
	
	@Override
	public void create(String title, String author, int year) {
		//RG-APP-12
		if (title == null) {
			System.out.println("Can't create Book, title is mandatory");
			return;
		}

		//RG-APP-13
		Book book = new Book(title, author, year);
		if (book.getCote() == "" || book.getCote() == null) {
			System.out.println("Can't create Book, cote is mandatory");
			return;
		}
		bookDao.save(book);
	}

	@Override
	public List<Book> getAvailableBooks() {
		List<Book> books = new ArrayList<Book>();
		
		List<Book> all =  bookDao.getAll();
		for (Book book : all) {
			if(book.isAvailable()) {
				books.add(book);
			}
		}
		return books;
	}

	@Override
	public List<Book> getBorrowedBooks() {
		List<Book> books = new ArrayList<Book>();
		
		List<Book> all =  bookDao.getAll();
		for (Book book : all) {
			if(! book.isAvailable()) {
				books.add(book);
			}
		}
		return books;
	}

}
