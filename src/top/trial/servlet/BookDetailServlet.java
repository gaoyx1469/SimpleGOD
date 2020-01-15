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
 * 展示书籍详情 记录浏览历史（写入cookie）
 * 
 * @author Gaoyx
 *
 */

@WebServlet("/BookDetailServlet")
public class BookDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookDetailServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 使用UTF-8编码
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		// 获取当前应用路径
		String path = request.getContextPath();
		out.append("Served at: ").append(path);

		// 展示书籍详情
		String bookId = request.getParameter("bookId");
		if (bookId != null && !"".equals(bookId)) {
			BookEntity book = BookEntityDB.getBook(bookId);
			out.write("书籍名称：" + book.getBookName() + "<br/>");
			out.write("书籍作者：" + book.getBookAuther() + "<br/>");
			out.write("书籍描述：" + book.getDiscription() + "<br/>");
			out.write("书籍售价：￥" + book.getPrice() + "<br/>");
		}

		out.write("<a href='" + path + "/BookMarketServlet'>返回</a>");

		// 记录cookie
		Cookie[] cs = request.getCookies();
		String bookHis = "";

		// 遍历看之前是否有名叫bookHis的cookie
		for (int i = 0; cs != null && i < cs.length; i++) {
			if (Constants.BOOK_HISTORY_COOKIE.equals(cs[i].getName())) {
				bookHis = cs[i].getValue();
			}
		}

		// 定义浏览历史数量
		int hisNum = 3;
		int realNum = 0;

		// 如果有，解析原cookie，将新的浏览历史放在最前面，并去重
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

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
