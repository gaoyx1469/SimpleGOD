package top.trial.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求转发演示，此类为目标组件
 * 
 * @author Gaoyx
 *
 */
@WebServlet("/GoalRequestServlet")
public class GoalRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GoalRequestServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取源组件放入ServletRequest域中的值并在页面输出
		String value = (String) request.getAttribute("key");
		response.getWriter().write(value);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
