package service;

import java.util.List;

import domain.UserVO;

public interface UserService {

	int register(UserVO uvo);

	UserVO login(UserVO uvo2);

	int lastlog(String id2);

	int modify(UserVO uvo2);

	int remove(String rid);

	List<UserVO> list();

}
