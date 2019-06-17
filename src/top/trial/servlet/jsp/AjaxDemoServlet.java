package top.trial.servlet.jsp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 演示Ajax调用后输出text纯文本
 * @author Gaoyx1469
 *
 */
@WebServlet("/AjaxDemoServlet")
public class AjaxDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Ajax Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String username = request.getParameter("username");
		String psw = request.getParameter("psw");
		response.getWriter().append("Ajax Served at: ").append(request.getContextPath()).append(username).append(":").append(psw);
	}

}
