package contorller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.UserVO;
import service.UserService;
import service.UserServiceImpl;


@WebServlet("/ucl/*")
public class UserContorller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static Logger log = LoggerFactory.getLogger(UserContorller.class);
	private RequestDispatcher rdp;
	private String destPage;
	private int isOk;
	private UserService usv;
    
    public UserContorller() {
        usv = new UserServiceImpl();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; Charset=utf-8");
		
		String uri = req.getRequestURI();
		log.info(" >>>>>> URI >>>>>> : " + uri);
		String path = uri.substring(uri.lastIndexOf("/")+1);
		log.info(" >>>>> path >>>>> : " + path);
		
		switch(path) {
		
		case "join":
			destPage = "/user/join.jsp";
			break;
		
		case "register":
//			id pw birth age name
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			String birth = req.getParameter("birth");
			int age = Integer.parseInt(req.getParameter("age"));
			String name = req.getParameter("name");
			
			UserVO uvo = new UserVO(id, pw, birth, age, name);
			isOk = usv.register(uvo);
			log.info(" >>>>> join >>>>> : " + (isOk > 0 ? "성공" : "실패"));
			destPage = "/";
			break;
			
		case "login":
			log.info(" >>>>> login page 이동 >>>>> : ");
			destPage = "/user/login.jsp";
			break;
			
			
		case "login_auth":
			try {
				String id2 = req.getParameter("id");
				String pw2 = req.getParameter("pw");
				UserVO uvo2 = new UserVO(id2, pw2);
				log.info(" >>>>> login 요청 >>>>> : ");
				UserVO Luvo = usv.login(uvo2);
				log.info(" >>>>> luvo >>>>> : " + Luvo);
				
				if(Luvo != null) {
					log.info(" >>>>> 1번");
					HttpSession ses = req.getSession();
					log.info(" >>>>> 2번");
					ses.setAttribute("ses", Luvo);
					ses.setMaxInactiveInterval(10*60);
					log.info(" >>>>> 3번");
				}else {
					req.setAttribute("msg_login", 0);
					log.info(" >>>>> 4번");
				}
				log.info(" >>>>> 5번");
				destPage = "/";
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;
			
			
		case "logout":
			try {
				HttpSession ses = req.getSession();
				UserVO uvo2 = (UserVO)ses.getAttribute("ses");
				String id2 = uvo2.getId();
				log.info(" >>>>> login ID >>>>> : "+id2);
				isOk = usv.lastlog(id2);
				log.info(" >>>>> logout >>>>> : " + (isOk > 0 ? "성공" : "실패"));
				ses.invalidate();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			destPage = "/";
			break;
			
		case "modify":
			log.info(" >>>>> modify page >>>>> : ");
			destPage ="/user/modify.jsp";
			break;
			
		case "edit":
//			pw birth age name
			
				String id2 = req.getParameter("id");
				String pw2 = req.getParameter("pw");
				String birth2 = req.getParameter("birth");
				int age2 = Integer.parseInt(req.getParameter("age"));
				String name2 = req.getParameter("name");
				UserVO uvo2 = new UserVO(id2, pw2, birth2, age2, name2);
				log.info(" >>>>> modify >>>>> : " + uvo2 );
				isOk = usv.modify(uvo2);
				log.info(" >>>>> modify >>>>> : " + (isOk > 0 ? "성공" : "실패"));
				if(isOk > 0) {
					HttpSession ses = req.getSession();
					UserVO rUvo = usv.login(uvo2);
					ses.setAttribute("ses", rUvo);
					destPage = "/";
				}else {
					req.setAttribute("msg_modify", "실패");
					destPage = "/user/modify.jsp";
				}
				break;			
				
			
			
		case "remove":
				try {
					HttpSession ses = req.getSession();
					String Rid = req.getParameter("id");
					log.info(" >>>>> removeID >>>>> : " + Rid);
					isOk = usv.remove(Rid);
					log.info(" >>>>> remove >>>>> : " + (isOk > 0 ? "성공" : "실패"));
					log.info(" >>>>> 삭제 후 로그아웃 완료 >>>>> : ");
					ses.invalidate();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				destPage = "/";
			break;
			
			
		case "list":
			try {
				List<UserVO> list = usv.list();
				req.setAttribute("list", list);
				log.info(" >>>>> 회원리스트 가져오기 >>>>> : 성공 : ");
				destPage = "/user/list.jsp";
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;		
			
		}
		
		
		
		rdp = req.getRequestDispatcher(destPage);
		rdp.forward(req, res);
		
	}

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(req, res);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(req, res);
		
	}

}
