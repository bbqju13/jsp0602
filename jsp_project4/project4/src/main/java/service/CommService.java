package service;

import java.util.List;

import domain.CommVO;

public interface CommService {

	int post(CommVO cvo);

	List<CommVO> getList(int tno);

	int remove(int cno);

	int modify(CommVO cvo);

}
