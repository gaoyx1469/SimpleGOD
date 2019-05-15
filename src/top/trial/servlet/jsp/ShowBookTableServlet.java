package top.trial.servlet.jsp;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.trial.demo.entity.BookEntity;
import top.trial.demo.entity.BookEntityDB;

@WebServlet("/ShowBookTableServlet")
public class ShowBookTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowBookTableServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// ��ȡͼ���б�
		Map<String, BookEntity> books = BookEntityDB.getAllBooks();

		// ��MAP�ŵ�request����
		request.setAttribute("books", books);

		// ����ת����showBookTable.jsp
		request.getRequestDispatcher("/JSP/trial/showBookTable.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
