package fr.htc.library.dao.book;

import java.util.ArrayList;
import java.util.List;

import fr.htc.library.model.Book;
import fr.htc.library.util.MapDataBases;

public class BookDaoMapImpl implements BookDao {

	public void save(Book book) {
		MapDataBases.getBooksMap().put(book.getCote(), book);
	}

	public Book findByCote(String cote) {
		return MapDataBases.getBooksMap().get(cote);
	}

	public List<Book> getAll() {
		return new ArrayList<Book>(MapDataBases.getBooksMap().values());
	}

}
