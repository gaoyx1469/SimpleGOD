package top.trial.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求转发演示，此类为源组件，请求后转发到GoalRequestServlet
 * 
 * @author 高宇翔
 *
 */
@WebServlet("/OriRequestServlet")
public class OriRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OriRequestServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 下面这句话有用，能起作用，因为请求转发时响应头不清空
		response.setContentType("text/html;charset=UTF-8");
		// 往ServletRequest域中放值
		request.setAttribute("key", "值-value");

		// 下面这句话木有输出，因为请求转发时响应体清空了
		response.getWriter().write("转发前参数");
		System.out.println("转发前参数");

		// 请求转发
		RequestDispatcher rd = request.getRequestDispatcher("/GoalRequestServlet");

		// 另一种得到RequestDispatcher的方式
		// rd = getServletContext().getRequestDispatcher("/GoalRequestServlet");

		// 转发
		rd.forward(request, response);

		// 下面这句话木有输出，因为请求已经转发了，后面写的都执行，但是response已经包装好了，不会再动了
		response.getWriter().write("转发后参数");
		System.out.println("转发后参数");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
