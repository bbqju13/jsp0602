package service;

import java.util.List;

import domain.PagingVO;
import domain.TablesVO;

public interface TableService {

	int insert(TablesVO tvo);

	List<TablesVO> list();

	int getTotal(PagingVO pgvo);

	List<TablesVO> getPageList(PagingVO pgvo);

	TablesVO get(int tno);

	int update(TablesVO tvo);

	int remove(int rtno);

	

}
