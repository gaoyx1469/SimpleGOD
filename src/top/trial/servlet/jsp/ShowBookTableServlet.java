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

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// 获取图书列表
		Map<String, BookEntity> books = BookEntityDB.getAllBooks();

		// 将MAP放到request域中
		request.setAttribute("books", books);

		// 请求转发到showBookTable.jsp
		request.getRequestDispatcher("/JSP/trial/showBookTable.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
