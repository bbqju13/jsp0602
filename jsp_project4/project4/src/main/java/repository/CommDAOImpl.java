package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CommVO;
import orm.DatabaseBuilder;

public class CommDAOImpl implements CommDAO {
	private static Logger log = LoggerFactory.getLogger(CommDAOImpl.class);
	private SqlSession sql;
	private String NS = "CommMapper.";
	private int isOk;

	public CommDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(CommVO cvo) {
		// TODO Auto-generated method stub
		log.info(" >>>>> insert DAO >>>>> : ");
		isOk = sql.insert(NS + "insert", cvo);
		if (isOk > 0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public List<CommVO> getList(int tno) {
		// TODO Auto-generated method stub
		log.info(" >>>>> list DAO >>>>> : ");
		return sql.selectList(NS + "list", tno);
	}

	@Override
	public int remove(int cno) {
		// TODO Auto-generated method stub
		log.info(" >>>>> remove DAO >>>>> : ");
		isOk = sql.insert(NS + "delete", cno);
		return isOk;
	}

	@Override
	public int modify(CommVO cvo) {
		// TODO Auto-generated method stub
		log.info(" >>>>> modify DAO >>>>> : ");
		isOk = sql.update(NS + "modify", cvo);
		if (isOk > 0) {
			sql.commit();
		}
		return isOk;
	}

}
