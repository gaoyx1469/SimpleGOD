package top.trial.encode;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��ʾ�����ַ����
 * 
 * @author ������
 *
 */
public class SysoChineseServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SysoChineseServletDemo() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String s = "�����ַ������ʾ";
		test4(request, response, s);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * �����ַ���ģʽ���,Ĭ��GBK����
	 * 
	 * @param request
	 * @param response
	 * @param s
	 * @throws IOException
	 */
	private void test1(HttpServletRequest request, HttpServletResponse response, String s) throws IOException {

		// ��������ַ���Ĭ��ISO-8859-1����,��ΪGBK���ر��룬��write������ָ���ı��뷽ʽ�����ַ�
		response.setCharacterEncoding("GBK");
		// ����ַ������
		PrintWriter out = response.getWriter();
		out.write(s);
	}

	/**
	 * �����ַ���ģʽ�������UTF-8��ʽ���벢֪ͨ���������
	 * 
	 * @param request
	 * @param response
	 * @param s
	 * @throws IOException
	 */
	private void test2(HttpServletRequest request, HttpServletResponse response, String s) throws IOException {

		// ��������ַ���Ĭ��ISO-8859-1����,��ΪUTF-8���ر���
		// response.setCharacterEncoding("UTF-8");
		// ֪ͨ�������UTF-8��ʽ����
		// response.setHeader("Content-Type", "text/html;charset=UTF-8");

		// ���ַ���������һ���ͬ����������
		response.setContentType("text/html;charset=UTF-8");

		// ����ַ������
		PrintWriter out = response.getWriter();
		out.write(s);
	}

	/**
	 * �����ֽ���ģʽ������������κα����ʽ��getBytes���Ա������GBK��������ǡ�������Ҳ�Ա�������������˲����롣
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
	 * �����ֽ���ģʽ��������ñ���ΪUTF-8
	 * 
	 * @param request
	 * @param response
	 * @param s
	 * @throws IOException
	 */
	private void test4(HttpServletRequest request, HttpServletResponse response, String s) throws IOException {
		
		OutputStream out = response.getOutputStream();
		
		// ��ʽһ��֪ͨ�����ʹ��UTF-8������
		// response.setHeader("Content-Type", "text/html;charset=UTF-8");
		// ��ʽ����IE�ɿ����ȸ��������ֱ�Ӱѱ�ǩ�����
		// out.write("<meta http-equiv='Content-Type' content='text/html;charset=UTF-8'>".getBytes());
		// ��ʽ����
		response.setContentType("text/html;charset=UTF-8");
		
		out.write(s.getBytes("UTF-8"));
	}
}
