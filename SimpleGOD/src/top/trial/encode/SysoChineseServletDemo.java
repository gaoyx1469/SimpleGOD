package top.trial.encode;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 演示中文字符输出
 * 
 * @author 高宇翔
 *
 */
public class SysoChineseServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SysoChineseServletDemo() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String s = "中文字符输出演示";
		test4(request, response, s);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * 中文字符流模式输出,默认GBK编码
	 * 
	 * @param request
	 * @param response
	 * @param s
	 * @throws IOException
	 */
	private void test1(HttpServletRequest request, HttpServletResponse response, String s) throws IOException {

		// 输出中文字符会默认ISO-8859-1编码,改为GBK本地编码，即write方法以指定的编码方式编码字符
		response.setCharacterEncoding("GBK");
		// 获得字符输出流
		PrintWriter out = response.getWriter();
		out.write(s);
	}

	/**
	 * 中文字符流模式输出，以UTF-8格式编码并通知浏览器解析
	 * 
	 * @param request
	 * @param response
	 * @param s
	 * @throws IOException
	 */
	private void test2(HttpServletRequest request, HttpServletResponse response, String s) throws IOException {

		// 输出中文字符会默认ISO-8859-1编码,改为UTF-8本地编码
		// response.setCharacterEncoding("UTF-8");
		// 通知浏览器以UTF-8格式解析
		// response.setHeader("Content-Type", "text/html;charset=UTF-8");

		// 在字符流中以下一句等同于上面两句
		response.setContentType("text/html;charset=UTF-8");

		// 获得字符输出流
		PrintWriter out = response.getWriter();
		out.write(s);
	}

	/**
	 * 中文字节流模式输出，不设置任何编码格式，getBytes会以本地码表（GBK）解析，恰好浏览器也以本地码表解析，因此不乱码。
	 * 
	 * @param request
	 * @param response
	 * @param s
	 * @throws IOException
	 */
	private void test3(HttpServletRequest request, HttpServletResponse response, String s) throws IOException {
		OutputStream out = response.getOutputStream();
		out.write(s.getBytes());
	}

	/**
	 * 中文字节流模式输出，设置编码为UTF-8
	 * 
	 * @param request
	 * @param response
	 * @param s
	 * @throws IOException
	 */
	private void test4(HttpServletRequest request, HttpServletResponse response, String s) throws IOException {
		
		OutputStream out = response.getOutputStream();
		
		// 方式一：通知浏览器使用UTF-8码表解码
		// response.setHeader("Content-Type", "text/html;charset=UTF-8");
		// 方式二：IE可靠，谷歌浏览器会直接把标签打出来
		// out.write("<meta http-equiv='Content-Type' content='text/html;charset=UTF-8'>".getBytes());
		// 方式三：
		response.setContentType("text/html;charset=UTF-8");
		
		out.write(s.getBytes("UTF-8"));
	}
}
