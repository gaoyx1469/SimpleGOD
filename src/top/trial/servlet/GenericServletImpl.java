package top.trial.servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet���ţ���ʾGenericServletʹ�ã�ʹ��ʱ����web.xml������ʹ��ע��
 * 
 * @author ������
 *
 */
public class GenericServletImpl extends GenericServlet {

	public GenericServletImpl() {
		System.out.println("�������޲ι��췽��");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("�����˳�ʼ��init����");
	}

	@Override
	public void destroy() {
		System.out.println("����������destroy����");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("������service����");
		OutputStream out = res.getOutputStream();
		out.write("Hello Servlet!".getBytes());
		// �ر�����������ǲ���Ҫ�����Զ���
		// out.close();
	}

}
