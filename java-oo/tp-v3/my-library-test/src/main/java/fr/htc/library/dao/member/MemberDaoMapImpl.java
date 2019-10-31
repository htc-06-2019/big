package fr.htc.library.dao.member;

import fr.htc.library.model.Member;
import fr.htc.library.util.MapDataBases;

public class MemberDaoMapImpl implements MemberDao {

	@Override
	public void save(Member member) {
		MapDataBases.getMembersMap().put(member.getMatricule(), member);
		
	}

	@Override
	public Member findByMatricule(String matricule) {
		return MapDataBases.getMembersMap().get(matricule);
	}

}
