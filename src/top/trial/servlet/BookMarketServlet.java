package top.trial.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

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
 * չʾ�����鼮�б� չʾ�û������ʷ����ȡcookie��
 * 
 * @author ������
 *
 */
@WebServlet("/BookMarketServlet")
public class BookMarketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookMarketServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ʹ��UTF-8����
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		// ��ȡ��ǰӦ��·��
		String path = request.getContextPath();
		out.append("Served at: ").append(path);

		// չʾ�鼮�б�
		out.write("<h1>�������лƽ���</h1>");
		Map<String, BookEntity> books = BookEntityDB.getAllBooks();

		for (Map.Entry<String, BookEntity> me : books.entrySet()) {
			out.write("<a href='" + path + "/BookDetailServlet?bookId=" + me.getKey() + "'>"
					+ me.getValue().getBookName() + "</a><br/>");
		}
		// չʾ�����ʷ
		Cookie[] cs = request.getCookies();
		for (int i = 0; cs != null && i < cs.length; i++) {
			Cookie c = cs[i];
			if (Constants.BOOK_HISTORY_COOKIE.equals(c.getName())) {
				out.write("<h3>�����ʷ��</h3>");
				String bookHis = c.getValue();
				String[] hisBooks = bookHis.split("-");
				for (String hisBook : hisBooks) {
					out.write("<a href='" + path + "/BookDetailServlet?bookId=" + hisBook + "'>"
							+ BookEntityDB.getBook(hisBook).getBookName() + "</a><br/>");
				}
				break;
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
