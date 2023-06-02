package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CommentVO;
import orm.DatabaseBuilder;

public class CommentDAOImpl implements CommentDAO {
	private static Logger log = LoggerFactory.getLogger(CommentDAOImpl.class);
	private SqlSession sql;
	private String NS = "CommentMapper.";

	public CommentDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(CommentVO cvo) {
		// TODO Auto-generated method stub
		log.info(" >> insert DAO 진입 : >> ");
		int isOk = sql.insert(NS + "insert", cvo);
		if (isOk > 0)
			sql.commit();
		return isOk;
	}

	@Override
	public List<CommentVO> getList(int bno) {
		// TODO Auto-generated method stub
		log.info(" >> list DAO 진입 : >> ");
		return sql.selectList(NS + "list", bno);
	}

	@Override
	public int remove(int cno) {
		// TODO Auto-generated method stub
		log.info(" >> remove DAO 진입 : >> ");
		int isOk = sql.insert(NS + "delete", cno);
		if (isOk > 0)
			sql.commit();
		return isOk;
	}

	@Override
	public int modify(CommentVO cvo) {
		// TODO Auto-generated method stub
		log.info(" >> modify DAO 진입 : >> ");
		int isOk = sql.update(NS + "modify", cvo);
		if(isOk > 0) {
			sql.commit();
		}
		return isOk;
	}

}
