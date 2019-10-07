package fr.htc.library.services.borrow;

import fr.htc.library.dao.book.BookDao;
import fr.htc.library.dao.book.BookDaoMapImpl;
import fr.htc.library.dao.member.MemberDao;
import fr.htc.library.dao.member.MemberDaoMapImpl;
import fr.htc.library.model.Book;
import fr.htc.library.model.Member;

public class BorrowServiceImpl implements BorrowService {

	private MemberDao memberDao = new MemberDaoMapImpl();
	private BookDao bookDao = new BookDaoMapImpl();

	@Override
	public boolean checkout(String matricule, String cote) {
		if (matricule == null || cote == null) {
			System.out.println("Can't complete operation : checkout) : matricule and cote are mandatory");
			return false;
		}

		Member member = memberDao.findByMatricule(matricule);
		if (member == null) {
			System.out.println("No Member matching with matricule :" + matricule);
			return false;
		}
		
		Book book = bookDao.findByCote(cote);
		if (book == null) {
			System.out.println("No Book matching with cote :" + cote);
			return false;
		}
		
		// build relation between Book and Member
		if(book.isAvailable() == false) {
			System.out.println("Book not available :" + cote);
			return false;
		}
		if(member.canCheckout() == false) {
			System.out.println("Memeber max book reached  :" + matricule);
			return false;
		}
		member.getBooks().add(book);
		book.setBorrower(member);
		
		System.out.println(book);
		System.out.println(member);
		return true;
	}

	@Override
	public boolean checkIn(String matricule, String cote) {
		if (matricule == null || cote == null) {
			System.out.println("Can't complete operation : checkout) : matricule and cote are mandatory");
			return false;
		}
		
		Member member = memberDao.findByMatricule(matricule);
		if (member == null) {
			System.out.println("No Member matching with matricule :" + matricule);
			return false;
		}
		
		Book book = bookDao.findByCote(cote);
		if (book == null) {
			System.out.println("No Book matching with cote :" + cote);
			return false;
		}
		
		if(member.canCheckin() == false) {
			System.out.println("Memeber no book reached  :" + matricule);
			return false;
		}
		
		member.getBooks().remove(book);
		book.setBorrower(null);		
		
		return false;
	}

	
}
