package top.trial.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.trial.demo.db.UserDB;
import top.trial.demo.entity.UserLoginEntity;
import top.util.security.Base64Util;
import top.util.security.MD5Util;

@WebServlet("/AutoLoginServlet")
public class AutoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AutoLoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		System.out.println(username);
		String password = request.getParameter("password");

		UserLoginEntity user = UserDB.findUserByNameAndPsw(username, password);

		if (user != null) {// 登录成功
			request.getSession().setAttribute("user", user);// user信息存Session
			String autoLoginFlag = request.getParameter("autoLoginFlag");
			if (autoLoginFlag != null) {// 自动登录勾选
				//cookie中不能存中文，因此用户名base64编码，密码使用MD5加密后base64编码
				Cookie cookie = new Cookie("autoLogin", Base64Util.base64Encoding(username) + "_" + MD5Util.generateMD5(password));
				cookie.setMaxAge(Integer.MAX_VALUE);// 有效期
				cookie.setPath(request.getContextPath());// 有效Path
				response.addCookie(cookie);// 返回cookie
			}
		}
		response.sendRedirect(request.getContextPath() + "/JSP/autoLogin/autoMain.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
