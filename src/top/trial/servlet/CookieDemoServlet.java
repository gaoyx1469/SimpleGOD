package top.trial.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��ס�û����һ�η���ʱ��lastAccessTime
 * 
 * @author Gaoyx
 *
 */
@WebServlet("/CookieDemoServlet")
public class CookieDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CookieDemoServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write("�ϴε�½ʱ�䣺");
		// ȡcookie��ָ��ֵ��ӡ��ҳ����
		Cookie[] cs = request.getCookies();
		for (int i = 0; cs != null && i < cs.length; i++) {
			Cookie c = cs[i];
			if ("lastAccessTime".equals(c.getName())) {
				String value = c.getValue();
				long time = Long.parseLong(value);
				pw.write(new Date(time).toLocaleString());
			}
		}
		// �ѵ�ǰ����ʱ��д��cookie
		Cookie ns = new Cookie("lastAccessTime", System.currentTimeMillis() + "");
		// ����cookie����������
		ns.setMaxAge(30 * 24 * 60 * 60);
		response.addCookie(ns);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
