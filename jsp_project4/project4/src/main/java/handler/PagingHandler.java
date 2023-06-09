package handler;

import domain.PagingVO;

public class PagingHandler {
	private int startPage;
	private int endPage;
	private boolean prev, next;
	private int totCnt;
	private PagingVO pgvo;
	
	public PagingHandler(PagingVO pgvo, int totCnt) {
		this.pgvo = pgvo;
		this.totCnt = totCnt;
		
		this.endPage = (int)Math.ceil(pgvo.getPageNo() / (pgvo.getQty()*1.0))*pgvo.getQty();
		this.startPage = this.endPage-9;
		
		int realEndPage = (int)(Math.ceil((totCnt*1.0)/pgvo.getQty()));
		if(realEndPage < this.endPage) {
			this.endPage = realEndPage;
		}
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEndPage;
	}
	
	
	
	
	

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getTotCnt() {
		return totCnt;
	}

	public void setTotCnt(int totCnt) {
		this.totCnt = totCnt;
	}

	public PagingVO getPgvo() {
		return pgvo;
	}

	public void setPgvo(PagingVO pgvo) {
		this.pgvo = pgvo;
	}

}
