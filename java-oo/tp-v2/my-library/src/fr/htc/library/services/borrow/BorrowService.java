package fr.htc.library.services.borrow;

public interface BorrowService {

	boolean checkout(String matricule, String cote);

	boolean checkIn(String matricule, String cote);
	
}
