package handler;

import domain.PagingVO;

public class PagingHandler {

	private int startPage; // 현재 화면에서 보여줄 시작 페이지네이션 번호
	private int endPage; // 현재 화면에서 보여줄 마지막 페이지네이션 번호
	private boolean prev, next; // 이전, 다음 버튼 존재 여부

	private int totalCnt; // 총 게시물 수
	private PagingVO pgvo;

	public PagingHandler(PagingVO pgvo, int totalCnt) {
		this.pgvo = pgvo;
		this.totalCnt = totalCnt;
		
		// 나머지 값 계산
		// 127개의 게시글 > 페이지네이션 번호 1~13개 필요
		// 현재 페이지에 보이는 / startpage = 1, endpage = 10 (다음)
		// 다음페이지 11페이지에 보이는 / (이전) startpage = 11 , endpage = 13 
		
		// (현재 페이지 번호 / 한 화면의 게시글 수) * 한 화면의 게시글수
		// * 1.0의 이유 -> 정수 / 정수 => 정수 (소수점을 남기기 위해서)
		// ex) (1 / 10) * 10 => 0.1(1) * 10 => 10
		// ex) (2 / 10) * 10 => 0.5(1) * 10 => 10
		// 10, 20, 30 ....
		// 1~10 페이지 까지 endPage = 10
		// 11~13 페이지 까지 endPage = 13
		this.endPage = (int)Math.ceil(pgvo.getPageNo() / (pgvo.getQty() * 1.0)) * pgvo.getQty(); // 소수점 만들려고 1.0 곱함
		this.startPage = this.endPage-9;
		
		// 페이지네이션의 전체 끝 페이지 realEndPage
		int realEndPage = (int)(Math.ceil((totalCnt * 1.0) / pgvo.getQty()));
		if(realEndPage < this.endPage) {
			this.endPage = realEndPage;
		}
		
		// 현재 화면에서 보여지는 startPage = 1, 11, 21, ...
		this.prev = this.startPage > 1; // 존재여부 ture / false 값이 올수있도록
		this.next = this.endPage < realEndPage; // ture / false 값이 올수있도록
		
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

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	public PagingVO getPgvo() {
		return pgvo;
	}

	public void setPgvo(PagingVO pgvo) {
		this.pgvo = pgvo;
	}
	
	
}
