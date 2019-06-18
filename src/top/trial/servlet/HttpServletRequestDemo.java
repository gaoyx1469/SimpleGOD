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
 * ��ʾ���HttpServletRequest�����еĸ�����Ϣ
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
		// �����URL������Э�顢IP���˿ڡ�URI
		String requestURL = request.getRequestURL().toString();
		// �������Դ��ַ
		String requestURI = request.getRequestURI();
		// ����Ĳ���
		String requestQS = request.getQueryString();
		// ���󷽵�IP
		String remoteAddr = request.getRemoteAddr();
		// ���󷽵Ķ˿ں�
		int remotePort = request.getRemotePort();
		// ����ķ���
		String method = request.getMethod();

		// -----------------------------------------------------------------

		// ��ȡָ����ͷ
		String header = request.getHeader("Accept-Encoding");
		// ��ȡȫ��ͷ
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

		// ����ȡ���������keyΪname��value��������ֻ��ȡ��һ��
		request.getParameter("name");
		// ����ȡ���������keyΪname��value�������Ķ����õ�
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
