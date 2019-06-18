package top.trial.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 演示输出HttpServletRequest对象中的各种信息
 * 
 * @author Gaoyx
 *
 */
@WebServlet("/HttpServletRequestDemo")
public class HttpServletRequestDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HttpServletRequestDemo() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 请求的URL，包括协议、IP、端口、URI
		String requestURL = request.getRequestURL().toString();
		// 请求的资源地址
		String requestURI = request.getRequestURI();
		// 请求的参数
		String requestQS = request.getQueryString();
		// 请求方的IP
		String remoteAddr = request.getRemoteAddr();
		// 请求方的端口号
		int remotePort = request.getRemotePort();
		// 请求的方法
		String method = request.getMethod();

		// -----------------------------------------------------------------

		// 获取指定的头
		String header = request.getHeader("Accept-Encoding");
		// 获取全部头
		ArrayList<String> headersList = new ArrayList();
		Enumeration<String> headers = request.getHeaderNames();
		while (headers.hasMoreElements()) {
			String headerName = headers.nextElement();
			Enumeration<String> theHeaders = request.getHeaders(headerName);
			while (theHeaders.hasMoreElements()) {
				headersList.add(headerName + "&" + theHeaders.nextElement());
			}
		}

		// -----------------------------------------------------------------

		// 这是取得请求参数key为name的value，重名的只能取第一个
		request.getParameter("name");
		// 这是取得请求参数key为name的value，重名的都能拿到
		request.getParameterValues("name");
		//
		request.getParameterNames();

		// -----------------------------------------------------------------

		PrintWriter out = response.getWriter();
		out.println("requestURL:" + requestURL + "    ");
		out.println("requestURI:" + requestURI + "    ");
		out.println("requestQS:" + requestQS + "    ");
		out.println("remoteAddr:" + remoteAddr + "    ");
		out.println("remotePort:" + remotePort + "    ");
		out.println("method:" + method + "    ");
		out.println("    ");
		out.println("Accept-Encoding:" + header + "    ");
		out.println("    ");

		for (String s : headersList) {
			out.println(s.substring(0, s.indexOf("&")) + ":" + s.substring(s.indexOf("&") + 1) + "    ");
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
