package service;

import java.util.ArrayList;
import java.util.List;

import domain.BoardVO;
import domain.PagingVO;

public interface BoardService {

	ArrayList<BoardVO> list();

	int insert(BoardVO bvo);

	BoardVO get(int bno);

	int update(BoardVO mbvo);

	int remove(int rbno);

	int getTotal(PagingVO pgvo);

	List<BoardVO> getPageList(PagingVO pgvo);

}
