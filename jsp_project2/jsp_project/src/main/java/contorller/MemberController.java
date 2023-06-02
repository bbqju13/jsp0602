package contorller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import service.MemberService;
import service.MemberServiceImpl;

@WebServlet("/mem/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// log설정
	// private static final Logger log = LoggerFactory.getLogger(클래스명);
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);

	private RequestDispatcher rdp;
	private MemberService msv;
	private int isOk;
	private String destPage;

	public MemberController() {
		msv = new MemberServiceImpl();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// CharacterEncoding 설정 / contentType / uri
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; Charset=utf-8");

		String uri = request.getRequestURI();
		log.info(" >> uri :" + uri);

		// /mem/join : 요청에 대한 path만 남기기
		String path = uri.substring(uri.lastIndexOf("/") + 1);
		log.info(" >> path :" + path);

		switch (path) {

		case "join":
			destPage = "/member/join.jsp";
			break;

		case "register":
			// jsp에서 가져온 파라미터 저장
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String email = request.getParameter("email");
			int age = Integer.parseInt(request.getParameter("age"));

			// 파라미터로 mvo객체 생성
			MemberVO mvo = new MemberVO(id, pw, email, age);
			isOk = msv.register(mvo);
			log.info(" >> JOIN : " + (isOk > 0 ? "성공" : "실패"));
			destPage = "/";
			break;

		case "login": // 로그인 페이지로 이동
			log.info(" >> login page 로이동");
			destPage = "/member/login.jsp";
			break;

		case "login_auth": // 실제 로그인이 일어나는 케이스

			try {

				String id2 = request.getParameter("id");
				String pw2 = request.getParameter("pw");
				MemberVO mvo2 = new MemberVO(id2, pw2);

				// 해당 id, pw가 DB상에 있는지 체크
				// 해당 객체(사용자)를 가져와야함
				// 해당 객체(사용자)를 세션에 담기
				log.info(" >> login 요청 : ");
				MemberVO loginMvo = msv.login(mvo2);

				// 같은정보가 있으면 객체를 리턴, 해당하는 값이 없다면 null이 리턴
				// 객체가 있다면 세션에 저장
				if (loginMvo != null) {
					// 세션 가져오기.연결된 세션이 없다면 새로 생성
					HttpSession ses = request.getSession();
					ses.setAttribute("ses", loginMvo);

					// 로그인 유지 시간 (초단위)
					ses.setMaxInactiveInterval(10 * 60);
				} else {
					// 세션을 못가져왔을때
					request.setAttribute("msg_login", 0);
				}
				destPage = "/";

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;

		case "logout":
			try {
				// 세션가져오기 (실제 연결된 세션)
				HttpSession ses = request.getSession();
				// 마지막 로그인 시간 기록.
				MemberVO mvo2 = (MemberVO) ses.getAttribute("ses");
				String id2 = mvo2.getId();
				log.info(" >>> login ID : " + id2);
				// 로그인정보(ID)를 주고, 로그인 시간(last_login) 기록 <update>
				isOk = msv.lastLogin(id2);
				log.info(" >> LOGOUT : " + (isOk > 0 ? "성공" : "실패"));
				ses.invalidate(); // invalidate() 권한 해제

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			destPage = "/";
			break;
			
		case "modify":
			log.info(" >> modify page 접근 : ");
			destPage = "/member/modify.jsp";
			break;

		case "edit":
						
			String id2 = request.getParameter("id");
			String pw2 = request.getParameter("pw");
			String email2 = request.getParameter("email");
			int age2 = Integer.parseInt(request.getParameter("age"));

			MemberVO mvo3 = new MemberVO(id2, pw2, email2, age2);
			isOk = msv.modify(mvo3);
			log.info(" >> modify : 완료,  session 변경시작 :");
			log.info(" >> modify : " + (isOk > 0 ? "성공" : "실패"));
			
			if (isOk > 0) {
				
				HttpSession ses = request.getSession();
				MemberVO reMvo = msv.login(mvo3); // modify 에서 모든정보를 가져오지 않았을경우
				ses.setAttribute("ses", reMvo);
				destPage = "/";
				
			} else {
				request.setAttribute("msg_modify", "실패");
				destPage = "/member/modify.jsp";
				
			}
			break;
			
		case "remove":
			// session객체에서 login정보 가져오기
			try {
				// 기존에 연결된 세션을 가져옴. (로그인 한 객체를 가져옴)
				HttpSession ses = request.getSession();
								
				// MemberVO reMvo = =(MemberVO)ses.getAttribute("ses");
				String removeId = request.getParameter("id");
				log.info(" >> login ID : " + removeId);
				isOk = msv.remove(removeId);
				log.info(" >> remove : " + (isOk > 0 ? "성공" : "실패"));
				log.info(" >> logout 완료 : ");
				ses.invalidate(); // 세션 로그아웃
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			destPage = "/index.jsp";
			break;
			
		case "list":
			try {
				ArrayList<MemberVO> list = msv.list();				
				request.setAttribute("list", list);
				log.info(" >> 회원리스트 가져오기 성공 : ");
				destPage = "/member/list.jsp";
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			break;
		}

		rdp = request.getRequestDispatcher(destPage);
		rdp.forward(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(request, response);
	}

}
