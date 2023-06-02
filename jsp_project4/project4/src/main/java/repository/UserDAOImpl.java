package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.UserVO;
import orm.DatabaseBuilder;

public class UserDAOImpl implements UserDAO {
	private static Logger log = LoggerFactory.getLogger(UserDAOImpl.class);
	private SqlSession sql;
	private String NS = "UserMapper.";

	public UserDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(UserVO uvo) {
		// TODO Auto-generated method stub
		log.info(" >>>>> insert DAO >>>>> : ");
		int isOk = sql.insert(NS + "reg", uvo);
		if (isOk > 0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public UserVO selectOne(UserVO uvo2) {
		// TODO Auto-generated method stub
		log.info(" >>>>> login DAO >>>>> : ");
		return sql.selectOne(NS + "login", uvo2);
	}

	@Override
	public int lastLogout(String id2) {
		// TODO Auto-generated method stub
		log.info(" >>>>> logout DAO >>>>> : ");
		int isOk = sql.update(NS + "logout", id2);
				if(isOk > 0) {
					sql.commit();
				}
		return isOk;
	}

	@Override
	public int modify(UserVO uvo2) {
		// TODO Auto-generated method stub
		log.info(" >>>>> modify DAO >>>>> : ");
		log.info(" >>>> uvo2 >>>>> : "+uvo2);
		int isOk = sql.update(NS + "modify", uvo2);
		if(isOk > 0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public int remove(String rid) {
		// TODO Auto-generated method stub
		log.info(" >>>>> delete DAO >>>>> : ");
		int isOk = sql.delete(NS + "delete", rid);
		if(isOk > 0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public List<UserVO> selectList() {
		// TODO Auto-generated method stub
		log.info(" >>>>> list DAO >>>>> : ");		
		return sql.selectList(NS + "list");
	}

}
