package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.PagingVO;
import domain.TablesVO;
import orm.DatabaseBuilder;

public class TableDAOImpl implements TableDAO {
	private Logger log = LoggerFactory.getLogger(TableDAOImpl.class);
	private SqlSession sql;
	private String NS = "tableMapper.";

	public TableDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(TablesVO tvo) {
		// TODO Auto-generated method stub
		log.info(" >>>>> insert DAO >>>>> : ");
		int isOk = sql.insert(NS + "insert", tvo);
		if(isOk>0) 	sql.commit();
		return isOk;
	}

	@Override
	public List<TablesVO> selectList() {
		// TODO Auto-generated method stub
		log.info(" >>>>> list DAO >>>>> : ");
		return sql.selectList(NS + "lsit");
	}

	@Override
	public int totCnt(PagingVO pgvo) {
		// TODO Auto-generated method stub
		log.info(" >>>>> totCnt DAO >>>>> : ");
		return sql.selectOne(NS + "cnt", pgvo);
	}

	@Override
	public List<TablesVO> pageList(PagingVO pgvo) {
		// TODO Auto-generated method stub
		log.info(" >>>>> pageList DAO >>>>> : ");
		return sql.selectList(NS + "selectList", pgvo);
	}

	@Override
	public TablesVO selectOne(int tno) {
		// TODO Auto-generated method stub
		log.info(" >>>>> get DAO >>>>> : ");
		TablesVO tvo = sql.selectOne(NS + "detail", tno);
		sql.commit();
		return tvo;
	}

	@Override
	public int update(TablesVO tvo) {
		// TODO Auto-generated method stub
		log.info(" >>>>> update DAO >>>>> : ");
		int isOk = sql.update(NS + "update", tvo);
		sql.commit();
		return isOk;
	}

	@Override
	public int delete(int rtno) {
		// TODO Auto-generated method stub
		log.info(" >>>>> delete DAO >>>>> : ");
		int isOk = sql.delete(NS + "delete", rtno);
		if (isOk > 0) {
			sql.commit();
		}
		return isOk;
	}

}