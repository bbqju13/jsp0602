/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.85
 * Generated at: 2023-06-01 05:56:54 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.table;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class detail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1685407619915L));
    _jspx_dependants.put("jar:file:/D:/_jsp_workspace/jsp_project4/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/project4/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425946270000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<link rel=\"stylesheet\" href=\"/resource/table/detail.css\">\n");
      out.write("<title>글상세</title>\n");
      out.write("<link\n");
      out.write("	href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\"\n");
      out.write("	rel=\"stylesheet\"\n");
      out.write("	integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\"\n");
      out.write("	crossorigin=\"anonymous\">\n");
      out.write("<script\n");
      out.write("	src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\"\n");
      out.write("	integrity=\"sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4\"\n");
      out.write("	crossorigin=\"anonymous\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("	<div class=\"container\">\n");
      out.write("		<table class=\"table table-striped\">\n");
      out.write("			<tr>\n");
      out.write("				<th>번호</th>\n");
      out.write("				<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tvo.tno}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("			</tr>\n");
      out.write("			<tr>\n");
      out.write("				<th>제목</th>\n");
      out.write("				<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tvo.title}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("			</tr>\n");
      out.write("			<tr>\n");
      out.write("				<th>작성자</th>\n");
      out.write("				<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tvo.writer}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("			</tr>\n");
      out.write("			<tr>\n");
      out.write("				<th>내용</th>\n");
      out.write("				<td>\n");
      out.write("					<div class=\"image-wrapper\">\n");
      out.write("						<img alt=\"XXX\" src=\"/_upload/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tvo.img_file}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("					</div> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tvo.content}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("				</td>\n");
      out.write("			</tr>\n");
      out.write("			<tr>\n");
      out.write("				<th>등록일</th>\n");
      out.write("				<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tvo.reg_date}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("			</tr>\n");
      out.write("		</table>\n");
      out.write("		<div class=\"button-wrapper\">\n");
      out.write("			<a href=\"/\">\n");
      out.write("				<button class=\"btn btn-primary\">처음으로</button>\n");
      out.write("			</a> <a href=\"/tcl/modify?tno=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tvo.tno}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("				<button class=\"btn btn-primary\" type=\"button\">수정</button>\n");
      out.write("			</a>\n");
      out.write("		</div>\n");
      out.write("		<hr>\n");
      out.write("		<div class=\"comment-section\">\n");
      out.write("			<input type=\"text\" id=\"cmtWriter\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ses.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"\n");
      out.write("				readonly=\"readonly\"> <br> <br>\n");
      out.write("			<div class=\"comment-input\">\n");
      out.write("				<textarea rows=\"5\" cols=\"30\" id=\"cmtText\" placeholder=\"댓글작정\"></textarea>\n");
      out.write("			</div>\n");
      out.write("			<br> <br>\n");
      out.write("			<div>\n");
      out.write("				<button type=\"button\" id=\"cmtAddBtn\" class=\"btn btn-primary\">댓글등록</button>\n");
      out.write("			</div>\n");
      out.write("		</div>\n");
      out.write("		<br> <br>\n");
      out.write("		<hr>\n");
      out.write("		<div class=\"accordion\" id=\"accordionExample\">\n");
      out.write("			<div class=\"accordion-item\">\n");
      out.write("				<h2 class=\"accordion-header\" id=\"headingOne\">\n");
      out.write("					<button class=\"accordion-button\" type=\"button\"\n");
      out.write("						data-bs-toggle=\"collapse\" data-bs-target=\"#collapseOne\"\n");
      out.write("						aria-expanded=\"true\" aria-controls=\"collapseOne\">댓글보기</button>\n");
      out.write("				</h2>\n");
      out.write("				<div id=\"collapseOne\" class=\"accordion-collapse collapse show\"\n");
      out.write("					aria-labelledby=\"headingOne\" data-bs-parent=\"#accordionExample\">\n");
      out.write("					<div class=\"accordion-body\">\n");
      out.write("						<div id=\"commentList\" class=\"comment-list\">\n");
      out.write("							<!-- 댓글 목록 출력 -->\n");
      out.write("						</div>\n");
      out.write("					</div>\n");
      out.write("				</div>\n");
      out.write("			</div>\n");
      out.write("		</div>\n");
      out.write("		<script type=\"text/javascript\">\n");
      out.write("			const tnoVal = ");
      if (_jspx_meth_c_005fout_005f0(_jspx_page_context))
        return;
      out.write(";\n");
      out.write("		</script>\n");
      out.write("		<script src=\"/resource/comm.js\"></script>\n");
      out.write("		<script type=\"text/javascript\">\n");
      out.write("			printCommList(tnoVal);\n");
      out.write("		</script>\n");
      out.write("\n");
      out.write("	</div>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fout_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    boolean _jspx_th_c_005fout_005f0_reused = false;
    try {
      _jspx_th_c_005fout_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fout_005f0.setParent(null);
      // /table/detail.jsp(87,18) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tvo.tno}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
      if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      _jspx_th_c_005fout_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fout_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fout_005f0_reused);
    }
    return false;
  }
}
