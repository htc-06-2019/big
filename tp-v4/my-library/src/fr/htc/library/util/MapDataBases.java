package fr.htc.library.util;

import java.util.HashMap;
import java.util.Map;

import fr.htc.library.model.Book;
import fr.htc.library.model.Member;

public class MapDataBases {
	
	private static Map<String, Member> membersMap = new HashMap<String, Member>();
	private static Map<String, Book> booksMap = new HashMap<String, Book>();
	
	private MapDataBases() {
	}

	public static Map<String, Member> getMembersMap() {
		return membersMap;
	}

	public static Map<String, Book> getBooksMap() {
		return booksMap;
	}

}
