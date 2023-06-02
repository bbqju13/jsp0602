package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.UserVO;
import repository.UserDAO;
import repository.UserDAOImpl;

public class UserServiceImpl implements UserService {
	private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	private UserDAO udao;
	
	public UserServiceImpl() {
		udao = new UserDAOImpl();
	}

	@Override
	public int register(UserVO uvo) {
		// TODO Auto-generated method stub
		log.info(" >>>>> register service 진입 >>>>> : ");
		return udao.insert(uvo);
	}

	@Override
	public UserVO login(UserVO uvo2) {
		// TODO Auto-generated method stub
		log.info(" >>>>> login service 진입 >>>>> : ");
		return udao.selectOne(uvo2);
	}

	@Override
	public int lastlog(String id2) {
		// TODO Auto-generated method stub
		log.info(" >>>>> loginout service 진입 >>>>> : ");
		return udao.lastLogout(id2);
	}

	@Override
	public int modify(UserVO uvo2) {
		// TODO Auto-generated method stub
		log.info(" >>>>> modify service 진입 >>>>> : ");
		return udao.modify(uvo2);
	}

	@Override
	public int remove(String rid) {
		// TODO Auto-generated method stub
		log.info(" >>>>> remove service 진입 >>>>> : ");
		return udao.remove(rid);
	}

	@Override
	public List<UserVO> list() {
		// TODO Auto-generated method stub
		log.info(" >>>>> list service 진입 >>>>> : ");
		return udao.selectList();
	}

}
