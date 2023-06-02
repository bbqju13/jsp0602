package service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import repository.MemberDAO;
import repository.MemberDAOImpl;


public class MemberServiceImpl implements MemberService {
	private static Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
	private MemberDAO mdao;
	
	public MemberServiceImpl() {
		mdao = new MemberDAOImpl();
	}
	@Override
	public int register(MemberVO mvo) {
		// TODO Auto-generated method stub
		log.info(" >> register service 진입 : ");
		return mdao.insert(mvo);
	}
	@Override
	public MemberVO login(MemberVO mvo2) {
		// TODO Auto-generated method stub
		log.info(" >> login service 진입 : ");
		return mdao.selectOne(mvo2);
	}
	@Override
	public int lastLogin(String id2) {
		// TODO Auto-generated method stub
		log.info(" >> logOut service 진입 : ");
		return mdao.lastLogin(id2);
	}
	@Override
	public int modify(MemberVO mvo3) {
		// TODO Auto-generated method stub
		log.info(" >> modify service 진입 : ");
		return mdao.modify(mvo3);
	}
	@Override
	public int remove(String id3) {
		// TODO Auto-generated method stub
		log.info(" >> remove service 진입 : ");
		return mdao.delete(id3);
	}
	@Override
	public ArrayList<MemberVO> list() {
		// TODO Auto-generated method stub
		log.info(" >> list service 진입 : ");
		return mdao.selectList();
	}

}
