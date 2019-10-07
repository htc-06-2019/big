package fr.htc.library.services.member;

import fr.htc.library.dao.member.MemberDao;
import fr.htc.library.dao.member.MemberDaoMapImpl;
import fr.htc.library.model.Member;

public class MemberServiceImpl implements MemberService {
	private MemberDao memberDao = new MemberDaoMapImpl();

	@Override
	public void create(String firstName, String lastName, int age) {
		
		Member member = new Member(firstName, lastName, age);
		memberDao.save(member);
	}

	@Override
	public Member findByMatricule(String matricule) {
		
		return memberDao.findByMatricule(matricule);
	}

}
