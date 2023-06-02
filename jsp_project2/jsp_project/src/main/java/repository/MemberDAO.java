package repository;

import java.util.ArrayList;

import domain.MemberVO;

public interface MemberDAO {

	int insert(MemberVO mvo);

	MemberVO selectOne(MemberVO mvo2);

	int lastLogin(String id2);

	int modify(MemberVO mvo3);

	int delete(String id3);

	ArrayList<MemberVO> selectList();

}
