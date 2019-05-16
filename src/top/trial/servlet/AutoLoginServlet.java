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

		if (user != null) {// ��¼�ɹ�
			request.getSession().setAttribute("user", user);// user��Ϣ��Session
			String autoLoginFlag = request.getParameter("autoLoginFlag");
			if (autoLoginFlag != null) {// �Զ���¼��ѡ
				//cookie�в��ܴ����ģ�����û���base64���룬����ʹ��MD5���ܺ�base64����
				Cookie cookie = new Cookie("autoLogin", Base64Util.base64Encoding(username) + "_" + MD5Util.generateMD5(password));
				cookie.setMaxAge(Integer.MAX_VALUE);// ��Ч��
				cookie.setPath(request.getContextPath());// ��ЧPath
				response.addCookie(cookie);// ����cookie
			}
		}
		response.sendRedirect(request.getContextPath() + "/JSP/autoLogin/autoMain.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
