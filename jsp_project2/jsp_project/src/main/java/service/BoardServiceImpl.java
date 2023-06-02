package service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.PagingVO;
import repository.BoardDAO;
import repository.BoardDAOImpl;

public class BoardServiceImpl implements BoardService {
	private static Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	private BoardDAO bdao;
	
	public BoardServiceImpl() {
		bdao = new BoardDAOImpl();
	}
	
	@Override
	public ArrayList<BoardVO> list() {
		// TODO Auto-generated method stub
		log.info(" >> list service 진입 : ");
		return bdao.selectList();
	}

	@Override
	public int insert(BoardVO bvo) {
		// TODO Auto-generated method stub
		log.info(" >> insert service 진입 : ");
		return bdao.insert(bvo);
	}

	@Override
	public BoardVO get(int bno) {
		// TODO Auto-generated method stub
		log.info("get service 진입 : ");
		return bdao.selectOne(bno);
	}

	@Override
	public int update(BoardVO mbvo) {
		// TODO Auto-generated method stub
		log.info("update service 진입 : ");
		return bdao.update(mbvo);
	}

	@Override
	public int remove(int rbno) {
		// TODO Auto-generated method stub
		log.info("remove service 진입 : ");
		return bdao.delete(rbno);
	}

	@Override
	public int getTotal(PagingVO pgvo) {
		// TODO Auto-generated method stub
		log.info("totCnt service 진입 : ");
		return bdao.totCnt(pgvo);
	}

	@Override
	public List<BoardVO> getPageList(PagingVO pgvo) {
		// TODO Auto-generated method stub
		return bdao.pageList(pgvo);
	}

}
