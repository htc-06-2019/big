package fr.htc.library.dao.member;

import fr.htc.library.model.Member;

public interface MemberDao {

	void save(Member member);

	Member findByMatricule(String matricule);

}
