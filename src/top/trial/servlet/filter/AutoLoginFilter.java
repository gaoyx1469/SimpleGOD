package top.trial.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.trial.demo.db.UserDB;
import top.trial.demo.entity.UserLoginEntity;
import top.util.security.Base64Util;
import top.util.security.MD5Util;
/**
 * 自动登录过滤器
 * @author Gaoyx
 *
 */
public class AutoLoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 读取session，有user，放行
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		if(req.getSession().getAttribute("user") == null){
			System.out.println("尝试自动登录");
			// 无user，读取cookie
			Cookie cookie = null;
			Cookie[] cookies = req.getCookies();
			if(cookies != null && cookies.length>0) {
				for (int i = 0; i < cookies.length; i++) {
					if ("autoLogin".equals(cookies[i].getName())) {
						cookie = cookies[i];
						break;
					}
				}
			}
			// 有cookie且用户名和加密的密码验证无误，拿到user且放session
			if(cookie != null) {
				String username = cookie.getValue().split("_")[0];
				String password = cookie.getValue().split("_")[1];
				UserLoginEntity user = UserDB.findUserByName(Base64Util.base64Decoding(username));
				if(user != null) {
					if(password.equals(MD5Util.generateMD5(user.getPassword()))) {
						req.getSession().setAttribute("user", user);
					}
				}
			}
		}
		chain.doFilter(req, resp);
	}

}
