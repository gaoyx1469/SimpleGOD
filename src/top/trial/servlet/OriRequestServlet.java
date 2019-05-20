package top.trial.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ����ת����ʾ������ΪԴ����������ת����GoalRequestServlet
 * 
 * @author ������
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

		// ������仰���ã��������ã���Ϊ����ת��ʱ��Ӧͷ�����
		response.setContentType("text/html;charset=UTF-8");
		// ��ServletRequest���з�ֵ
		request.setAttribute("key", "ֵ-value");

		// ������仰ľ���������Ϊ����ת��ʱ��Ӧ�������
		response.getWriter().write("ת��ǰ����");
		System.out.println("ת��ǰ����");

		// ����ת��
		RequestDispatcher rd = request.getRequestDispatcher("/GoalRequestServlet");

		// ��һ�ֵõ�RequestDispatcher�ķ�ʽ
		// rd = getServletContext().getRequestDispatcher("/GoalRequestServlet");

		// ת��
		rd.forward(request, response);

		// ������仰ľ���������Ϊ�����Ѿ�ת���ˣ�����д�Ķ�ִ�У�����response�Ѿ���װ���ˣ������ٶ���
		response.getWriter().write("ת�������");
		System.out.println("ת�������");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
