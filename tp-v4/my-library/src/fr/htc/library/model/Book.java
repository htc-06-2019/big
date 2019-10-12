package fr.htc.library.model;

public class Book {
	private static int BOOK_SEQ = 10;
	private String cote;
	private String title;
	private String author;
	private int year;
	
	private Member borrower;

	public Member getBorrower() {
		return borrower;
	}

	public void setBorrower(Member borrower) {
		this.borrower = borrower;
	}

	public Book(String title, String author, int year) {
		this.title = title;
		this.author = author;
		this.year = year;
		this.cote = this.generateCote();
	}

	private String generateCote() {
		return this.author.substring(0, 2).toUpperCase() + ("" + this.year).substring(2) + "-" + BOOK_SEQ++;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCote() {
		return cote;
	}

	@Override
	public String toString() {
		return "Book [cote=" + cote + ", title=" + title + ", author=" + author + ", year=" + year 
				 + " " +  (borrower != null ? borrower.getMatricule() : "Dispo" ) + "]";
	}

	public boolean isAvailable() {
		if(this.borrower == null) {
			return true;
		}
		return false;
	}

}
