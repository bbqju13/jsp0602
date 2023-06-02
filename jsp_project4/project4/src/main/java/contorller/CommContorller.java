package contorller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CommVO;
import service.CommContorllerImpl;
import service.CommService;


@WebServlet("/ccl/*")
public class CommContorller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(CommContorller.class);
	private int isOk;
	private CommService csv;
	private final String UTF8 = "utf-8";
	
	public CommContorller() {
		csv = new CommContorllerImpl();
	}
       

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding(UTF8);
		res.setCharacterEncoding(UTF8);
		String uri = req.getRequestURI();
		log.info(" >>>>> URI >>>>> : " + uri);
		
		String Pathuri = uri.substring("/ccl/".length());
		String path = Pathuri;
		String pathVar = "";
		if(Pathuri.contains("/")) {
			path = Pathuri.substring(0, Pathuri.lastIndexOf("/"));
			pathVar = Pathuri.substring(Pathuri.lastIndexOf("/")+1);
		}
		log.info(" >>>>> path >>>>> : " + path);
		log.info(" >>>>> pathVar >>>>> : " + pathVar);
		
		
		switch(path) {
		
		case "post":
			try {
				StringBuffer sb = new StringBuffer();
				String line = "";
				BufferedReader br = req.getReader();
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				log.info(" >>>>> SB >>>>> : " + sb.toString());
				
				JSONParser parser = new JSONParser();
				JSONObject jObj = (JSONObject)parser.parse(sb.toString());
				int tno = Integer.parseInt(jObj.get("tno").toString());
				String writer = jObj.get("writer").toString();
				String content = jObj.get("content").toString();
				CommVO cvo = new CommVO(tno, writer, content);
				isOk = csv.post(cvo);
				log.info(" >>>>> post >>>>> : " + (isOk > 0 ? "성공" : "실패"));
				
				PrintWriter out = res.getWriter();
				out.print(isOk);
			} catch (Exception e) {
				// TODO: handle exception
				log.info(" >>>>> COMM POST ERR >>>>> : ");
				e.printStackTrace();
			}
			break;
			
			
		case "list":
			try {
				int tno = Integer.parseInt(pathVar);
				
				List<CommVO> list = csv.getList(tno);
				log.info(" >>>>> Comm List >>>>> DB OK : " );
				
				JSONObject[] jsobjArr = new JSONObject[list.size()];
				JSONArray jsobjList = new JSONArray();
				
				for(int i=0; i<list.size(); i++) {
					jsobjArr[i] = new JSONObject();
					jsobjArr[i].put("cno", list.get(i).getCno());
					jsobjArr[i].put("tno", list.get(i).getTno());
					jsobjArr[i].put("writer", list.get(i).getWriter());
					jsobjArr[i].put("content", list.get(i).getContent());
					jsobjArr[i].put("reg_date", list.get(i).getReg_date());
					
					jsobjList.add(jsobjArr[i]);
				}
				log.info(" >>>>> jsonobjlist >>>>> : " + jsobjList);
				String jsonData = jsobjList.toJSONString();
				log.info(" >>>>> jsonData >>>>> : " + jsonData);
				
				PrintWriter out = res.getWriter();
				out.print(jsonData);
				
			} catch (Exception e) {
				// TODO: handle exception
				log.info(" >>>>> list ERR >>>>> : ");
				e.printStackTrace();
			}
			break;
			
		case "remove":
			try {
				int cno = Integer.parseInt(req.getParameter("cnoVal"));
				log.info(" >>>>> cno >>>>> : " + cno);
				isOk = csv.remove(cno);
				
				log.info(" >>>>> remove >>>>> : " + (isOk > 0 ? "성공" : "실패"));
				PrintWriter out = res.getWriter();
				out.print(isOk);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;
			
		case "modify":
			try {
				StringBuffer sb = new StringBuffer();
				String line;
				BufferedReader br = req.getReader();
				while((line = br.readLine()) != null) {
					sb.append(line);
				}
				log.info(" >>>>> SB >>>>> : " + sb.toString());
				
				JSONParser parser = new JSONParser();
				JSONObject jsObj = (JSONObject)parser.parse(sb.toString());
				
				int cno = Integer.parseInt(jsObj.get("cno").toString());
				String content = jsObj.get("content").toString();
				
				CommVO cvo = new CommVO(cno, content);
				isOk = csv.modify(cvo);
				log.info(" >>>>> modify >>>>> : " + (isOk > 0 ? "성공" : "실패"));
				
				PrintWriter out = res.getWriter();
				out.print(isOk);
			} catch (Exception e) {
				// TODO: handle exception
				log.info(" >>>>> modify ERR >>>>>");
				e.printStackTrace();
			}
			break;
			
			
			
		
		}
		
		
		
		
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
