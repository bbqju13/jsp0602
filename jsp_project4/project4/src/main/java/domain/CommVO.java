package domain;

public class CommVO {
	private int cno;
	private int tno;
	private String writer;
	private String content;
	private String reg_date;
	
	public CommVO() {}

	// 작성 tno writer content
	public CommVO(int tno, String writer, String content) {
		
		this.tno = tno;
		this.writer = writer;
		this.content = content;
	}

	// writer content cno
	public CommVO(String writer, String content, int cno) {
		
		this.writer = writer;
		this.content = content;
		this.cno = cno;
	}

	// 수정 cno content
	public CommVO(int cno, String content) {
		
		this.cno = cno;
		this.content = content;
	}

	// all
	public CommVO(int cno, int tno, String writer, String content, String reg_date) {
		
		this.cno = cno;
		this.tno = tno;
		this.writer = writer;
		this.content = content;
		this.reg_date = reg_date;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public int getTno() {
		return tno;
	}

	public void setTno(int tno) {
		this.tno = tno;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "CommVO [cno=" + cno + ", tno=" + tno + ", writer=" + writer + ", content=" + content + ", reg_date="
				+ reg_date + "]";
	}
	
	
	
	
	
	
}
