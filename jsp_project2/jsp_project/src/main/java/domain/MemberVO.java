package domain;

public class MemberVO {
	/* id varchar(255) not null primary key,
pw varchar(255) not null,
email varchar(255) not null,
age int not null,
reg_date datetime default now(),
last_login datetime default null

	 * */
	
	private String id;
	private String pw;
	private String email;
	private int age;
	private String reg_date;
	private String last_login;
	
	public MemberVO() {}
	
	// login id,pw
	public MemberVO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	// join (회원가입) id pw email age
	public MemberVO(String id, String pw, String email, int age) {
		this.id = id;
		this.pw = pw;
		this.email = email;
		this.age = age;
	}

	// list (회원정보) id email age reg_date last_date
	public MemberVO(String id, String email, int age, String reg_date, String last_login) {
		this.id = id;
		this.email = email;
		this.age = age;
		this.reg_date = reg_date;
		this.last_login = last_login;
	}

	// modify (회원정보수정) pw email age
	public MemberVO(String pw, String email, int age) {
		this.pw = pw;
		this.email = email;
		this.age = age;
	}
	

//	public MemberVO(String id, String pw, String email, int age, String reg_date, String last_login) {
//		this.id = id;
//		this.pw = pw;
//		this.email = email;
//		this.age = age;
//		this.reg_date = reg_date;
//		this.last_login = last_login;
//	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public String getLast_login() {
		return last_login;
	}

	public void setLast_login(String last_login) {
		this.last_login = last_login;
	}

	@Override
	public String toString() {
		return "MemberVO [아이디=" + id + ", 비밀번호=" + pw + ", 이메일=" + email + ", 나이=" + age + ", 등록일=" + reg_date
				+ ", 마지막로그인=" + last_login + "]";
	}
		
}
