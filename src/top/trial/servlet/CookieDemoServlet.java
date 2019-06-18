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
 * 记住用户最后一次访问时间lastAccessTime
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
		pw.write("上次登陆时间：");
		// 取cookie中指定值打印到页面上
		Cookie[] cs = request.getCookies();
		for (int i = 0; cs != null && i < cs.length; i++) {
			Cookie c = cs[i];
			if ("lastAccessTime".equals(c.getName())) {
				String value = c.getValue();
				long time = Long.parseLong(value);
				pw.write(new Date(time).toLocaleString());
			}
		}
		// 把当前访问时间写回cookie
		Cookie ns = new Cookie("lastAccessTime", System.currentTimeMillis() + "");
		// 设置cookie的生命周期
		ns.setMaxAge(30 * 24 * 60 * 60);
		response.addCookie(ns);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
