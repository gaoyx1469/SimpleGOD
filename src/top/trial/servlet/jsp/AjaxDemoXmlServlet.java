package top.trial.servlet.jsp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 演示Ajax调用后输出text纯文本
 * 
 * @author Gaoyx
 *
 */

@WebServlet("/AjaxDemoXmlServlet")
public class AjaxDemoXmlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String xmlMsg = "<tiny><om id='1'><name>mane</name><value>25</value></om><om id='2'><name>luma</name><value>28</value></om></tiny>";
		response.setContentType("text/xml;charset=utf-8");
		response.getWriter().print(xmlMsg);

	}

}
