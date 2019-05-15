package top.trial.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.trial.config.Constants;
import top.trial.demo.entity.BookEntity;
import top.trial.demo.entity.BookEntityDB;

/**
 * չʾ�鼮���� ��¼�����ʷ��д��cookie��
 * 
 * @author ������
 *
 */

@WebServlet("/BookDetailServlet")
public class BookDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookDetailServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ʹ��UTF-8����
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		// ��ȡ��ǰӦ��·��
		String path = request.getContextPath();
		out.append("Served at: ").append(path);

		// չʾ�鼮����
		String bookId = request.getParameter("bookId");
		if (bookId != null && !"".equals(bookId)) {
			BookEntity book = BookEntityDB.getBook(bookId);
			out.write("�鼮���ƣ�" + book.getBookName() + "<br/>");
			out.write("�鼮���ߣ�" + book.getBookAuther() + "<br/>");
			out.write("�鼮������" + book.getDiscription() + "<br/>");
			out.write("�鼮�ۼۣ���" + book.getPrice() + "<br/>");
		}

		out.write("<a href='" + path + "/BookMarketServlet'>����</a>");

		// ��¼cookie
		Cookie[] cs = request.getCookies();
		String bookHis = "";

		// ������֮ǰ�Ƿ�������bookHis��cookie
		for (int i = 0; cs != null && i < cs.length; i++) {
			if (Constants.BOOK_HISTORY_COOKIE.equals(cs[i].getName())) {
				bookHis = cs[i].getValue();
			}
		}

		// ���������ʷ����
		int hisNum = 3;
		int realNum = 0;

		// ����У�����ԭcookie�����µ������ʷ������ǰ�棬��ȥ��
		if (!"".equals(bookHis)) {
			String[] books = bookHis.split("-");
			bookHis = bookId;
			realNum++;
			for (int j = 0; j < books.length && realNum < hisNum; j++) {
				if (!books[j].equals(bookId)) {
					bookHis = bookHis + "-" + books[j];
					realNum++;
				}
			}
		} else {
			bookHis = bookId;
		}

		System.out.println(bookHis);
		Cookie cookie = new Cookie(Constants.BOOK_HISTORY_COOKIE, bookHis);
		cookie.setMaxAge(60 * 60 * 24 * 30);
		cookie.setPath(path);
		response.addCookie(cookie);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
