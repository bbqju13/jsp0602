package repository;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import orm.DatabaseBuilder;

public class MemberDAOImpl implements MemberDAO {
	private static Logger log = LoggerFactory.getLogger(MemberDAOImpl.class);
	private SqlSession sql;
	
	// NameSpace(NS) = SQL이 mapper를 구분하기 위한 이름
	// NameSpace.SQL구문이름
	private String NS = "MemberMapper.";
	
	public MemberDAOImpl() {
		// DB연결
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}
	
	@Override
	public int insert(MemberVO mvo) {
		// insert
		// sql.insert(MemberMapper.reg, 객체);
		// insert는 transaction 처리가 자동 이루어짐.
		int isOk = sql.insert(NS + "reg", mvo);
		
		if(isOk > 0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public MemberVO selectOne(MemberVO mvo2) {
		// TODO Auto-generated method stub
		log.info(" >> login DAO 진입 : ");
		return sql.selectOne(NS + "login", mvo2);
	}

	@Override
	public int lastLogin(String id2) {
		// TODO Auto-generated method stub
		
		log.info(" >> logOut DAO 진입 : ");
		int isOk = sql.update(NS+"logout", id2);
		if(isOk > 0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public int modify(MemberVO mvo3) {
		// TODO Auto-generated method stub
		log.info(" >> modify DAO 진입 : ");
		int isOk = sql.update(NS + "modify", mvo3);
		if(isOk > 0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public int delete(String id3) {
		// TODO Auto-generated method stub
		log.info(" >> delete DAO 진입 : ");
		int isOk = sql.delete(NS + "remove", id3);
		
		if(isOk > 0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public ArrayList<MemberVO> selectList() {
		// TODO Auto-generated method stub
		log.info(" >> list DAO 진입 : ");
		
		return new ArrayList<MemberVO>(sql.selectList(NS+"list"));
	}

}
