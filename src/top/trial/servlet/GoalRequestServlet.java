package top.trial.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ����ת����ʾ������ΪĿ�����
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

		// ��ȡԴ�������ServletRequest���е�ֵ����ҳ�����
		String value = (String) request.getAttribute("key");
		response.getWriter().write(value);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
