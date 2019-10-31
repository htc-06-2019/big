package fr.htc.library.services.borrow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import fr.htc.library.dao.book.BookDao;
import fr.htc.library.dao.book.BookDaoMapImpl;
import fr.htc.library.dao.member.MemberDao;
import fr.htc.library.dao.member.MemberDaoMapImpl;
import fr.htc.library.model.Book;
import fr.htc.library.model.Member;
import fr.htc.library.services.book.BookService;
import fr.htc.library.services.book.BookServiceImpl;
import fr.htc.library.services.member.MemberService;
import fr.htc.library.services.member.MemberServiceImpl;;

public class BorrowServiceImplTest {
	private BookService bookService = new BookServiceImpl();
	private MemberService memberService = new MemberServiceImpl();
	private BorrowService borrowService = new BorrowServiceImpl();
	private BookDao bookDao = new BookDaoMapImpl();
	private MemberDao memberDao = new MemberDaoMapImpl();
	
	
	@Test
	public void  testCheckout() {
		String matricule = "MD100";
		String cote = "YA00-10";
		
		boolean actualResult = borrowService.checkout(null, cote);
		assertEquals("Can't checkout with null matricule", false, actualResult);
		
		actualResult = borrowService.checkout("", cote);
		assertEquals("Can't checkout with null matricule", false, actualResult);
		
		actualResult = borrowService.checkout(matricule, null);
		assertEquals("Can't checkout with null cote", false, actualResult);
		
		actualResult = borrowService.checkout(matricule, "");
		assertEquals("Can't checkout with null cote", false, actualResult);
		
		actualResult = borrowService.checkout(null, null);
		assertEquals("Can't checkout with null matricule and cote", false, actualResult);
		
		actualResult = borrowService.checkout("", "");
		assertEquals("Can't checkout with null matricule and cote", false, actualResult);
		
		actualResult = borrowService.checkout("  ", "  ");
		assertEquals("Can't checkout with null matricule and cote", false, actualResult);
		
		
		actualResult = borrowService.checkout("BLABLA", cote);
		assertEquals("Can't checkout with null matricule and cote", false, actualResult);
		
		actualResult = borrowService.checkout(matricule, "TRALALA");
		assertEquals("Can't checkout with null matricule and cote", false, actualResult);
		
		
		//************************* Test checkout unavailable book **********************
		Book book = bookDao.findByCote(cote);
		//Simuler book not availlable
		book.setBorrower(new Member("zarez", "zerzae", 20));
		assertFalse(book.isAvailable());
		actualResult = borrowService.checkout(matricule, cote);
		assertEquals("Can't checkout with unavailable book", false, actualResult);
		//***********************************************
		
		Member member = memberDao.findByMatricule(matricule);
		member.getBooks().add(new Book("sqdfsq", "bfbb", 2015));
		member.getBooks().add(new Book("gfthf", "zerze", 2010));
		member.getBooks().add(new Book("rzer", "ezrze", 2012));
		
		book.setBorrower(null);
		
		actualResult = borrowService.checkout(member.getMatricule(), book.getCote());
		assertEquals("Can't checkout with memebr attempt max boox size", false, actualResult);
		
		//************************************************************************************
		member.getBooks().clear();
		
		actualResult = borrowService.checkout(member.getMatricule(), book.getCote());
		assertEquals("checkout must be done normaly", true, actualResult);
		
		assertEquals("the book saved on the member list must be equal to book checked out", member.getBooks().get(0), book);
		assertEquals("the book saved on the member list must be equal to book checked out", book.getBorrower(), member);
		assertFalse(book.isAvailable());
		
		assertTrue(member.canCheckout());
	
	}
	
	@Test
	@Ignore
	public void testCheckIn() {
		fail("not implemented yet");
	}

	@Before
	public void init() {
		String title = "Ce que le jours doit à la nuit";
		String author = "Yasmina KHADRA";
		int year = 2000;
		
		System.out.println("ici");
		bookService.create(title, author, year);
		bookService.create(title, author, year);
		bookService.create(title, author, year);
		bookService.create(title, author, year);
		
		String firstName = "Djamel";
		String lastName = "MOUCHENE";
		int age = 25;
		memberService.create(firstName, lastName, age);
		memberService.create(firstName, lastName, age);
	}
}
