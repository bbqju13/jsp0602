package contorller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.simple.ItemList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.PagingVO;
import domain.TablesVO;
import handler.FileHandler;
import handler.PagingHandler;
import net.coobird.thumbnailator.Thumbnails;
import service.TableService;
import service.TableServiceImpl;

@WebServlet("/tcl/*")
public class TableContorller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(TableContorller.class);
	private RequestDispatcher rdp;
	private String destPage;
	private int isOk;
	private TableService tsv;
	private String savePath;
	private final String UTF8 = "utf-8";

	public TableContorller() {
		tsv = new TableServiceImpl();
		// TODO Auto-generated constructor stub
	}

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding(UTF8);
		res.setCharacterEncoding(UTF8);
		res.setContentType("text/html; charset=utf-8");

		String uri = req.getRequestURI();
		log.info(" >>>>> URI >>>>> : " + uri);
		String path = uri.substring(uri.lastIndexOf("/") + 1);
		log.info(" >>>>> path >>>>> : " + path);

		switch (path) {

		case "register":
			destPage = "/table/register.jsp";
			break;

		case "insert":
			try {
				savePath = getServletContext().getRealPath("/_upload");
				log.info(" >>>>> savePath >>>>> : " + savePath);
				File filedir = new File(savePath);

				DiskFileItemFactory fif = new DiskFileItemFactory();
				fif.setRepository(filedir);
				fif.setSizeThreshold(2 * 1024 * 1024);

				TablesVO tvo = new TablesVO();

				ServletFileUpload fileUpload = new ServletFileUpload(fif);
				List<FileItem> itemlist = fileUpload.parseRequest(req);
				for (FileItem item : itemlist) {
					log.info(" >>>>> 아이템 정보 >>>>> : " + item);

					switch (item.getFieldName()) {
					case "title":
						tvo.setTitle(item.getString(UTF8));
						break;

					case "writer":
						tvo.setWriter(item.getString(UTF8));
						break;

					case "content":
						tvo.setContent(item.getString(UTF8));
						break;

					case "img_file":
						if (item.getSize() > 0) {
							String filename = item.getName().substring(item.getName().lastIndexOf("/") + 1);
							filename = System.currentTimeMillis() + "_" + filename;
							log.info(" >>>>> 파일이름 >>>>> : " + filename);
							File ufp = new File(filedir + File.separator + filename);
							log.info(" >>>>> 파일경로 >>>>> : " + ufp);

							try {
								item.write(ufp);
								tvo.setImg_file(filename);
								Thumbnails.of(ufp).size(75, 75)
										.toFile(new File(filedir + File.separator + "th_" + filename));
							} catch (Exception e) {
								// TODO: handle exception
								e.printStackTrace();
							}
						}
						break;
					}
				}
				isOk = tsv.insert(tvo);
				log.info(" >>>>> insert >>>>> : " + (isOk > 0 ? "성공" : "실패"));
				destPage = "page";
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;

		case "list":
			try {
				List<TablesVO> list = tsv.list();
				req.setAttribute("lsit", list);
				log.info(" >>>>> 글목록 가져오기 성공 >>>>> : ");
				destPage = "/table/list.jsp";
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;

		case "page":
			try {
				int pageNo = 1;
				int qty = 10;

				String type = "";
				String keyword = "";
				if (req.getParameter("type") != null) {
					type = req.getParameter("type");
					keyword = req.getParameter("keyword");
					log.info(" >>>>> type >>>>> : " + type + " >>>>> keyword >>>>> : " + keyword);
				}
				if (req.getParameter("pageNo") != null) {
					pageNo = Integer.parseInt(req.getParameter("pageNo"));
					qty = Integer.parseInt(req.getParameter("qty"));
				}
				PagingVO pgvo = new PagingVO(pageNo, qty);
				pgvo.setType(type);
				pgvo.setKeyword(keyword);
				log.info(" >>>>> pgvo >>>>> : " + pgvo);

				int totCnt = tsv.getTotal(pgvo);
				log.info(" >>>>> 전체페이지개수 >>>>> : " + totCnt + "개");

				List<TablesVO> list = tsv.getPageList(pgvo);
				log.info(" >>>>> list >>>>> : " + list.get(0));
				log.info(" >>>>> list >>>>> : " + list);
				PagingHandler ph = new PagingHandler(pgvo, totCnt);
				req.setAttribute("pgh", ph);
				req.setAttribute("list", list);
				log.info(" >>>>> pageList 성공 >>>>> : ");
				destPage = "/table/list.jsp";
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;

		case "detail":
			try {
				int tno = Integer.parseInt(req.getParameter("tno"));
				TablesVO tvo = tsv.get(tno);
				log.info(" >>>>> tno >>>>> : " + tno);
				req.setAttribute("tvo", tvo);
				destPage = "/table/detail.jsp";
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;

		case "modify":
			int tno = Integer.parseInt(req.getParameter("tno"));
			try {
				TablesVO tvo = tsv.get(tno);
				req.setAttribute("tvo", tvo);
				destPage = "/table/modify.jsp";
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;

		case "edit":
			try {
				savePath = getServletContext().getRealPath("/_upload");
				File fileDir = new File(savePath);
				DiskFileItemFactory dfif = new DiskFileItemFactory();
				dfif.setRepository(fileDir);
				dfif.setSizeThreshold(2 * 1024 * 1024);

				TablesVO tvo = new TablesVO();
				ServletFileUpload ful = new ServletFileUpload(dfif);
				log.info(" >>>>> update 준비 >>>>> : ");

				List<FileItem> itemlist = ful.parseRequest(req);
				String old_file = null;
				for (FileItem item : itemlist) {
					switch (item.getFieldName()) {
					case "tno":
						tvo.setTno(Integer.parseInt(item.getString(UTF8)));
						break;
					case "title":
						tvo.setTitle(item.getString(UTF8));
						break;
					case "content":
						tvo.setContent(item.getString(UTF8));
						break;
					case "img_file":
						old_file = item.getString(UTF8);
						break;
					case "new_file":
						if (item.getSize() > 0) {
							if (old_file != null) {
								FileHandler fh = new FileHandler();
								isOk = fh.deleteFile(old_file, savePath);
							}
							String FileName = item.getName().substring(item.getName().lastIndexOf("/") + 1);
							log.info(" >>>>> new_file >>>>> : " + FileName);

							FileName = System.currentTimeMillis() + "_" + FileName;
							File ufp = new File(fileDir + File.separator + FileName);
							try {
								item.write(ufp);
								tvo.setImg_file(FileName);
								log.info(" >>>>> tvo.img_fileName >>>>> : " + tvo.getImg_file());
								Thumbnails.of(ufp).size(75, 75)
										.toFile(new File(fileDir + File.separator + "th_" + FileName));

							} catch (Exception e) {
								// TODO: handle exception
								log.info(" >>>>> file update on disk 실패 >>>>> ");
								e.printStackTrace();
							}
						} else {
							tvo.setImg_file(old_file);
						}
						break;
					}
				}
				isOk = tsv.update(tvo);
				log.info(" >>>>> edit >>>>> : " + (isOk > 0 ? "성공" : "실패"));
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			destPage ="page";
			break;
		
		case "remove":
			try {
				int Rtno = Integer.parseInt(req.getParameter("tno"));
				TablesVO tvo = tsv.get(Rtno);
				String savePath = getServletContext().getRealPath("/_upload");
				String filename = tvo.getImg_file();
				
				FileHandler fh = new FileHandler();
				fh.deleteFile(filename, savePath);
				
				isOk = tsv.remove(Rtno);
				log.info(" >>>>> removefilename >>>>> : " + filename);
				log.info(" >> remove : " + (isOk > 0 ? "성공" : "실패"));
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			destPage = "page";
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
