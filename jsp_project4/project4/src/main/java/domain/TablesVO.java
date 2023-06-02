package domain;

public class TablesVO {
	private int tno;
	private String title;
	private String writer;
	private String content;
	private String reg_date;
	private String img_file;
	
	public TablesVO() {}

	// 등록register title writer content img_file
	public TablesVO(String title, String writer, String content, String img_file) {
		
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.img_file = img_file;
	}

	// 목록list tno title writer reg_date img_file
	public TablesVO(int tno, String title, String writer, String reg_date, String img_file) {
		
		this.tno = tno;
		this.title = title;
		this.writer = writer;
		this.reg_date = reg_date;
		this.img_file = img_file;
	}

	// 상세detail all
	public TablesVO(int tno, String title, String writer, String content, String reg_date, String img_file) {
		
		this.tno = tno;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.reg_date = reg_date;
		this.img_file = img_file;
	}

	// 수정 tno title content
	public TablesVO(int tno, String title, String content) {
		
		this.tno = tno;
		this.title = title;
		this.content = content;
	}

	public int getTno() {
		return tno;
	}

	public void setTno(int tno) {
		this.tno = tno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getImg_file() {
		return img_file;
	}

	public void setImg_file(String img_file) {
		this.img_file = img_file;
	}

	@Override
	public String toString() {
		return "TablesVO [게시글 번호 =" + tno + ", 제목 =" + title + ", 작성자 =" + writer + ", 내용 =" + content
				+ ", 작성일 =" + reg_date + ", 이미지 파일 =" + img_file + "]";
	}
	
	
	
	
	
	
}
