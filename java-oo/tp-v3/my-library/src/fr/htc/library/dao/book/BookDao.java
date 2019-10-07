package fr.htc.library.dao.book;

import java.util.List;

import fr.htc.library.model.Book;

public interface BookDao {

	public void save(Book book);

	public Book findByCote(String cote);

	public List<Book> getAll();

}
