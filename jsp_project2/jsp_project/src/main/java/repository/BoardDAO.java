package repository;

import java.util.ArrayList;
import java.util.List;

import domain.BoardVO;
import domain.PagingVO;

public interface BoardDAO {

	ArrayList<BoardVO> selectList();

	int insert(BoardVO bvo);

	BoardVO selectOne(int bno);

	int update(BoardVO mbvo);

	int delete(int rbno);

	int totCnt(PagingVO pgvo);

	List<BoardVO> pageList(PagingVO pgvo);

}
