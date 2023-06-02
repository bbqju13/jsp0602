package repository;

import java.util.List;

import domain.PagingVO;
import domain.TablesVO;

public interface TableDAO {

	int insert(TablesVO tvo);

	List<TablesVO> selectList();

	int totCnt(PagingVO pgvo);

	List<TablesVO> pageList(PagingVO pgvo);

	TablesVO selectOne(int tno);

	int update(TablesVO tvo);

	int delete(int rtno);

	

}
