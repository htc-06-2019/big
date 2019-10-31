package fr.htc.library.services.book;

import java.util.List;

import fr.htc.library.model.Book;

public interface BookService {

	public void create(String title, String author, int year);

	public List<Book> getAvailableBooks();

	public List<Book> getBorrowedBooks();

}
