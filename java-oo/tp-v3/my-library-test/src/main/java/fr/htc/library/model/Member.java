package fr.htc.library.model;

import java.util.ArrayList;
import java.util.List;

public class Member {
	private static int MEMBER_SEQ = 100;
	private static final int MAX_CHECKOUT_BOOK = 3;
	private String matricule;
	private String firstName;
	private String lastName;
	private int age;
	
	private List<Book> books = new ArrayList<Book>();

	public Member(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.matricule = generateMatricule();

	}

	@Override
	public String toString() {
		StringBuilder bookCotes = new StringBuilder("");
		for (Book book : books) {
			bookCotes.append(" | " + book.getCote());
		}
		bookCotes.append(" |");
		
		return "Member [matricule=" + matricule + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age +
				bookCotes.toString() + "]";
	}

	/**
	 * 
	 * @return
	 */
	private String generateMatricule() {
		return (lastName.substring(0, 1) + firstName.substring(0, 1)).toUpperCase() + MEMBER_SEQ++;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMatricule() {
		return matricule;
	}

	
	public List<Book> getBooks() {
		return books;
	}

	public boolean canCheckout() {
		if(this.books.size() < MAX_CHECKOUT_BOOK) {
			return true;
		}
		return false;
	}

}
