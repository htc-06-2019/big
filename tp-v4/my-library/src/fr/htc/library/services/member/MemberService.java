package fr.htc.library.services.member;

import fr.htc.library.model.Member;

public interface MemberService {

	public void create(String firstName, String lastName, int age);

	public Member findByMatricule(String matricule);

}
